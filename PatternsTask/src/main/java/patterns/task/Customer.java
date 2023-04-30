package patterns.task;

import java.io.Serializable;
import java.util.*;

public class Customer implements Serializable {
    private final String name;
    private final ArrayList<Rental> rentals;
    public HashSet<Movie> userFavoriteMovies;

    public void setOwed(double owed) {
        this.owed = owed;
    }

    public void setBonusPoints(double bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public double getOwed() {
        return owed;
    }

    public double getBonusPoints() {
        return bonusPoints;
    }

    private double owed;
    private double bonusPoints;

    public Customer(String name, ArrayList<Rental> rentals, HashSet<Movie> userFavoriteMovies, double owed, double bonusPoints) {
        this.name = name;
        this.rentals = rentals;
        this.userFavoriteMovies = userFavoriteMovies;
        this.owed = owed;
        this.bonusPoints = bonusPoints;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", rentals=" + rentals +
                ", userFavoriteMovies=" + userFavoriteMovies +
                '}';
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = each.getAmount();
            frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints);
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + getOwed() + "\n";
        result += "You earned " + getBonusPoints() + " frequent renter points";
        return result;
    }
}
