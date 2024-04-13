package com.cgu.railwayreservationsystemejava;

public class PassengerTicket {
    private int id;
    private String train_name;
    private String from_station;
    private String to_station;
    private String date_travel;
    private String coach_class;
    private String num_passengers;
    private String passenger_name;
    private String passenger_email;
    private String passenger_phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getFrom_station() {
        return from_station;
    }

    public void setFrom_station(String from_station) {
        this.from_station = from_station;
    }

    public String getTo_station() {
        return to_station;
    }

    public void setTo_station(String to_station) {
        this.to_station = to_station;
    }

    public String getDate_travel() {
        return date_travel;
    }

    public void setDate_travel(String date_travel) {
        this.date_travel = date_travel;
    }

    public String getCoach_class() {
        return coach_class;
    }

    public void setCoach_class(String coach_class) {
        this.coach_class = coach_class;
    }

    public String getNum_passengers() {
        return num_passengers;
    }

    public void setNum_passengers(String num_passengers) {
        this.num_passengers = num_passengers;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_email() {
        return passenger_email;
    }

    public void setPassenger_email(String passenger_email) {
        this.passenger_email = passenger_email;
    }

    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }
}
