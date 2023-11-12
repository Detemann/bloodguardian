module com.sarrussys.bloodguardian {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.persistence;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires net.bytebuddy;
    requires java.sql;

    opens com.sarrussys.bloodguardian to javafx.fxml;
    exports com.sarrussys.bloodguardian;
    exports com.sarrussys.bloodguardian.controllers;
    exports com.sarrussys.bloodguardian.models;
    opens com.sarrussys.bloodguardian.controllers to javafx.fxml;
}