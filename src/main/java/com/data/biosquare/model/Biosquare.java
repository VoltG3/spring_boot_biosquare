package com.data.biosquare.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "biosquares")

public class Biosquare {
    private long id;
    private String landcode;
    private String landname;
    private String region;
    private Integer population;
    private Float landarea;
    private String landmap;
    public Biosquare() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


    @Column(name = "landcode")
        public String getLandcode() {
            return landcode;
        }

        public void setLandcode(String landcode) {
            this.landcode = landcode;
        }

    @Column(name = "landname")
        public String getLandname() {
            return landname;
        }

        public void setLandname(String landname) {
            this.landname = landname;
        }

    @Column(name = "region")
        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

    @Column(name = "population")
        public Integer getPopulation() {
            return population;
        }

        public void setPopulation(Integer population) {
            this.population = population;
        }

    @Column(name = "landarea")
        public Float getLandarea() {
            return landarea;
        }

        public void setLandarea(Float landarea) {
            this.landarea = landarea;
        }

    @Column(name = "landmap")
        public String getLandmap() {
            return landmap;
        }

        public void setLandmap(String landmap) {
            this.landmap = landmap;
        }

}
