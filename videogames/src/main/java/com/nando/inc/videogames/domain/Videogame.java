package com.nando.inc.videogames.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Domain Bean VideoGame.
 *
 * @author fernando.penaranda
 */
@Entity
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String videogameName;
    private String description;
    private String urlImage;

    @ManyToOne
    private Provider provider;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getVideogameName() {
        return videogameName;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setVideogameName(String videogameName) {
        this.videogameName = videogameName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "Videogame{" + "id=" + id + ", videogameName=" + videogameName + ", description=" + description + ", urlImage=" + urlImage + ", provider=" + provider.getId() + '}';
    }
    
}
