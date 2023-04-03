package es.sport.radar.domain;

public class Team {

    private String name;

   private Integer score;

   public Team(String name){
       this.name = name;
       score = 0;
   }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String toString() {
        return this.name + " " + this.score;
    }

}
