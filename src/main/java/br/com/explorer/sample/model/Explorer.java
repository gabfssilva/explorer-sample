package br.com.explorer.sample.model;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class Explorer {
    private Long id;
    private Planet planet;
    private Direction direction;
    private Integer xPosition;
    private Integer yPosition;

    public Explorer() {
    }

    public Explorer(Long id, Planet planet, Direction direction, Integer xPosition, Integer yPosition) {
        this.id = id;
        this.planet = planet;
        this.direction = direction;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Integer getxPosition() {
        return xPosition;
    }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Explorer explorer = (Explorer) o;

        if (id != null ? !id.equals(explorer.id) : explorer.id != null) return false;
        if (planet != null ? !planet.equals(explorer.planet) : explorer.planet != null) return false;
        if (xPosition != null ? !xPosition.equals(explorer.xPosition) : explorer.xPosition != null) return false;
        return !(yPosition != null ? !yPosition.equals(explorer.yPosition) : explorer.yPosition != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (planet != null ? planet.hashCode() : 0);
        result = 31 * result + (xPosition != null ? xPosition.hashCode() : 0);
        result = 31 * result + (yPosition != null ? yPosition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Explorer{" +
                "id=" + id +
                ", planet=" + planet +
                ", direction=" + direction +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
