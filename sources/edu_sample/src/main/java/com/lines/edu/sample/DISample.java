package com.lines.edu.sample;

public class DISample {
    public static void main(String[] args) {
//        Reservation reservation = new Reservation(rsvn);
//        reservation.doReservation(RSVN_TYPE.FIT);
//
//
//        Reservation reservationDi1 = new Reservation(rsvn);
//        reservationDi1.setRsvn(new FITRsvn());
//        reservation.processReservation();


        Reservation reservation = new Reservation(new FITRsvn());
        reservation.processReservation();


    }
}

enum RSVN_TYPE {
    FIT,
    GROUP
}


class Reservation {

    private Rsvn rsvn;

    private final Rsvn rsvnConstructor;

    Reservation(Rsvn rsvn) {
        this.rsvnConstructor = rsvn;
    }

    public void doReservation(RSVN_TYPE rsvnType){
        if (rsvnType == RSVN_TYPE.FIT){
            FITRsvn fitRsvn = new FITRsvn();
            fitRsvn.reservation();

            // ~~~
        } else if(rsvnType == RSVN_TYPE.GROUP){
            GroupRsvn groupRsvn = new GroupRsvn();
            groupRsvn.reservation();

            // ~~~~
            // ~~~
            // ~~~~
            // ~~~
            // ~~~~
            // ~~~~

        }
    }


    public void setRsvn(Rsvn rsvn) {
        this.rsvn = rsvn;
    }

    public void processReservation(){
        rsvn.reservation();
    }
}

interface Rsvn {
    public void reservation();
}

class FITRsvn implements Rsvn {

    public void reservation(){
        System.out.println("Fit Reservation");
    }
}

class GroupRsvn implements Rsvn {
    public void reservation(){
        System.out.println("Group Reservation");
    }
}
