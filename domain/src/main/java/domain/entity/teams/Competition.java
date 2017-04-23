package domain.entity.teams;

import javax.persistence.*;

/**
 * Created by Никита on 23.04.2017.
 */

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "db_id")
    private Long dbId;

    @Column(name = "flag_url")
    private String flagUrl;

    @Column(name = "region")
    private String region;

    public Competition() {
    }

    public Competition(String name, String fullName, Long dbId, String flagUrl, String region) {
        this.name = name;
        this.fullName = fullName;
        this.dbId = dbId;
        this.flagUrl = flagUrl;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
