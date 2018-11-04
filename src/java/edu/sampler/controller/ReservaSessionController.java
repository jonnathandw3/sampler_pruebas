/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import edu.sampler.entity.Reserva;
import edu.sampler.entity.Sala;
import edu.sampler.facade.ReservaFacadeLocal;
import edu.sampler.facade.SalaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "reservaSessionController")
@SessionScoped
public class ReservaSessionController implements Serializable {

    @EJB
    ReservaFacadeLocal reservaFacadeLocal;
    @EJB
    SalaFacadeLocal salaFacadeLocal;

    private ScheduleModel eventModel;
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();

    private Reserva reservaActualizar;
    private String codigoReserva;
    private int salaReserva;
    private String documentoCliente;
    private String nombreCliente;
    private Date fechaReserva;
    private Date horaInicio;
    private Date horaFin;

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public void setLazyEventModel(ScheduleModel lazyEventModel) {
        this.lazyEventModel = lazyEventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public Reserva getReservaActualizar() {
        return reservaActualizar;
    }

    public void setReservaActualizar(Reserva reservaActualizar) {
        this.reservaActualizar = reservaActualizar;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getSalaReserva() {
        return salaReserva;
    }

    public void setSalaReserva(int sala) {
        this.salaReserva = sala;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Creates a new instance of ReservaSessionController
     */
    public ReservaSessionController() {
    }

    public String ingresarReserva() throws ParseException {
        try {
            Reserva res = new Reserva();
            Date fecha = new Date();
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm");

            double numeroAleatori = Math.random() * 1000000;
            int claveInt = (int) numeroAleatori;
            String rese = "R" + claveInt;

            res.setCodigoReserva(rese);
            res.setSala(salaFacadeLocal.find(salaReserva));
            res.setDocumentoCliente(documentoCliente);
            res.setNombreCliente(nombreCliente);
            res.setFechaReserva(fechaReserva);
            res.setHoraInicio(horaInicio);
            res.setHoraFin(horaFin);
            reservaFacadeLocal.create(res);
            this.limpiarFormulario();
            addMessage(new FacesMessage("Su registro fue ingresado correctamente"));
            return "ok";
        } catch (Exception e) {
            addMessage(new FacesMessage("Hubo un error en la creación del registro"));
            return null;
        }
    }

    public void actualizarReserva() {
        reservaFacadeLocal.edit(reservaActualizar);
    }

    public void eliminarReserva(Reserva reservaEliminar) {
        reservaFacadeLocal.remove(reservaEliminar);
    }

    public void limpiarFormulario() {
        this.salaReserva = 0;
        this.documentoCliente = "";
        this.nombreCliente = "";
        this.fechaReserva = Date.from(Instant.MIN);
        this.horaInicio = null;
        this.horaFin = null;
    }

    @PostConstruct
    public void init() {
        List<Reserva> reservas = reservaFacadeLocal.findAll();
        eventModel = new DefaultScheduleModel();
        for (Reserva res : reservas) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar.setTime(res.getFechaReserva());
            calendar1.setTime(res.getFechaReserva());
            int inicio = (int) res.getHoraInicio().getTime();
            int fin = (int) res.getHoraFin().getTime();
            calendar.set(Calendar.MONTH, res.getFechaReserva().getMonth());
            calendar1.set(Calendar.MONTH, res.getFechaReserva().getMonth());
            calendar.set(Calendar.HOUR, res.getHoraInicio().getHours());
            calendar1.set(Calendar.HOUR, res.getHoraFin().getHours());

            DefaultScheduleEvent evTemp = new DefaultScheduleEvent("Espacio reservado para " + res.getNombreCliente(), calendar.getTime(), calendar1.getTime(), res);
            //evTemp.setEditable(false);
            //evTemp.setId(res.getIdreserva().toString());
            eventModel.addEvent(evTemp);
        }

        lazyEventModel = new LazyScheduleModel() {

            @Override
            public void loadEvents(Date start, Date end) {
                Date random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 1", random, random));

                random = getRandomDate(start);
                addEvent(new DefaultScheduleEvent("Lazy Event 2", random, random));
            }
        };
    }

    public Date getRandomDate(Date base) {
        Calendar date = Calendar.getInstance();
        date.setTime(base);
        date.add(Calendar.DATE, ((int) (Math.random() * 30)) + 1);    //set random day of month

        return date.getTime();
    }

    public Date getInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTime();
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);

        return t.getTime();
    }

    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);

        return t.getTime();
    }

    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }

    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);

        return t.getTime();
    }

    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    public void addEvent(ActionEvent actionEvent) {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        reservaActualizar = (Reserva) event.getData();
//        reservaActualizar.setNombreCliente(res.getNombreCliente());
//        reservaActualizar.setDocumentoCliente(res.getDocumentoCliente());
//        reservaActualizar.setHoraInicio(res.getHoraInicio());
//        fechaReserva = reservaActualizar.getFechaReserva();
//        horaInicio = reservaActualizar.getHoraInicio();
//        horaFin = reservaActualizar.getHoraFin();
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
