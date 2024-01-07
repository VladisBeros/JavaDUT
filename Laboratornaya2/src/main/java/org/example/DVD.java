package org.example;

class DVD extends Item {
    private int duration;

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if (!this.isBorrowed) {
            this.isBorrowed = true;
            System.out.println("DVD позаимствован: " + this.title);
        } else {
            System.out.println("DVD уже взят на время.");
        }
    }

    @Override
    public void returnItem() {
        if (this.isBorrowed) {
            this.isBorrowed = false;
            System.out.println("DVD возвращен: " + this.title);
        } else {
            System.out.println("DVD не был одолжен.");
        }
    }
}