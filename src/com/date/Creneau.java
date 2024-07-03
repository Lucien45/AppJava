package com.date;

import java.time.Duration;
import java.time.LocalTime;

public class Creneau {
	private int id;
	private String titre;
	private LocalTime hdebut;
	private LocalTime hfin;
	private int totalHMinute;
	
	public Creneau(int id, String titre, LocalTime hdebut, LocalTime hfin) {
		this.id = id;
		this.titre = titre;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.totalHMinute = calculTotalTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalTime getHdebut() {
		return hdebut;
	}

	public void setHdebut(LocalTime hdebut) {
		this.hdebut = hdebut;
	}

	public LocalTime getHfin() {
		return hfin;
	}

	public void setHfin(LocalTime hfin) {
		this.hfin = hfin;
	}

	public int getTotalHMinute() {
		return totalHMinute;
	}

	public void setTotalHMinute(int totalHMinute) {
		this.totalHMinute = totalHMinute;
	}

	@Override
	public String toString() {
		return "Creneau [id=" + id + ", titre=" + titre + ", hdebut=" + hdebut + ", hfin=" + hfin + ", totalHMinute="
				+ totalHMinute + "]";
	}
	
	private int calculTotalTime() {
        if (this.hdebut != null && this.hfin != null) {
            return (int) Duration.between(this.hdebut, this.hfin).toMinutes();
        }
        return 0;
    }

    public void printTotalTime() {
        int hours = this.totalHMinute / 60;
        int minutes = this.totalHMinute % 60;
        System.out.println("Total heure docteur: " + hours + " hours and " + minutes + " minutes");
    }
}
