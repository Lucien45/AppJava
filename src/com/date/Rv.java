package com.date;

public class Rv {
    private int id;
    private int duree;
    private String jour;
    private Creneau creneau;

    public Rv(int id, int duree, String jour, Creneau creneau) {
        this.id = id;
        this.duree = duree;
        this.jour = jour;
        this.creneau = creneau;
        calculDuree();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    @Override
    public String toString() {
        return "Rv [id=" + id + ", duree=" + duree + ", jour=" + jour + ", creneau=" + creneau + "]";
    }

    private void calculDuree() {
        int totalMinutes = this.creneau.getTotalHMinute() - this.duree;
        if (totalMinutes < 0) {
            totalMinutes = 0;
        }
        this.creneau.setTotalHMinute(totalMinutes);
    }

    public void printRemainingTime() {
        int totalMinutes = this.creneau.getTotalHMinute();
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        System.out.println("Total heure docteur reste: " + hours + " hours and " + minutes + " minutes");
    }

    public static boolean estDisponible(Creneau creneau, int duree) {
        return creneau.getTotalHMinute() >= duree;
    }
}
