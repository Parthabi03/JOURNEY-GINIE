package edu.rims.Journey_Ginie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import edu.rims.Journey_Ginie.constant.WidgetStatus;


@Entity
@Table(name = "widget")
@Getter
@Setter
public class Widget extends Auditable {

    @Id
    @Column(name = "widget_id", length = 255, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String widgetId;

    @Column(name = "widget_name", length = 100, nullable = false)
    private String widgetName;

    @Column(name = "sequence")
    private Integer sequence;

    @Enumerated(EnumType.STRING)
    @Column(name = "widget_status", columnDefinition = "ENUM('AVAILABLE','UNAVAILABLE') DEFAULT 'AVAILABLE'")
    private WidgetStatus widgetStatus = WidgetStatus.AVAILABLE;

    @ManyToMany
    @JoinTable(name = "widget_product", joinColumns = @JoinColumn(name = "widget_id"), inverseJoinColumns = @JoinColumn(name = "destination_id"))
    private List<Destination> destinations;

    public void addDestination(Destination destination) {
        if (destinations == null)
            destinations = new ArrayList<>();
        destinations.add(destination);
    }

    // Remove a destination from the tour
    public void removeDestination(String destinationId) {
        destinations.remove(destinationId);
    }
}