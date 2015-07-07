package br.com.explorer.sample.model;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class Planet {
    private Long id;
    private String name;
    private Integer height;
    private Integer width;

    public Planet() {
    }

    public Planet(Long id, String name, Integer height, Integer width) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.width = width;
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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        if (id != null ? !id.equals(planet.id) : planet.id != null) return false;
        if (name != null ? !name.equals(planet.name) : planet.name != null) return false;
        if (height != null ? !height.equals(planet.height) : planet.height != null) return false;
        return !(width != null ? !width.equals(planet.width) : planet.width != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        return result;
    }
}
