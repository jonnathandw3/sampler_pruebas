/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sampler.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author fecor
 */
@Named(value = "reporteRequestController")
@RequestScoped
public class ReporteRequestController {

    /**
     * Creates a new instance of ReporteRequestController
     */
    public ReporteRequestController() {
    }

    private String documento;
    private String sede;
    private String fechaFactura;

    public void imprimirParametro() throws ClassNotFoundException, SQLException {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/Reportes.jasper"));
            Map<String, Object> params = new HashMap<>();
            params.put("Documento_Cliente", documento);
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampler", "sampler", "Sampler2018*");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=" + documento + ".pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void cliente() throws ClassNotFoundException, SQLException {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/Clientes.jasper"));
            Map<String, Object> params = new HashMap<>();
//            params.put("Documento_Cliente", documento);
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampler", "sampler", "Sampler2018*");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename= Clientes.pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void imprimirSede() throws ClassNotFoundException, SQLException {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/activosFijosSede.jasper"));
            Map<String, Object> params = new HashMap<>();
            params.put("sede", sede);
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampler", "sampler", "Sampler2018*");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=" + sede + ".pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void imprimirFactura() throws ClassNotFoundException, SQLException, ParseException {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/Factura.jasper"));
            Map<String, Object> params = new HashMap<>();
           
            
            DateFormat format;
            format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(fechaFactura);

            params.put("FechaFactura", date);
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampler", "sampler", "Sampler2018*");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=FacturaSampler.pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
        public void detalleSede() throws ClassNotFoundException, SQLException {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            File jasper = new File(ec.getRealPath("/Reportes/Sede.jasper"));
            Map<String, Object> params = new HashMap<>();
            params.put("sede", sede);
//            params.put("logo", ec.getRealPath("/resources/img/user-perfil.png"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sampler", "sampler", "Sampler2018*");
            JasperPrint jp = JasperFillManager.fillReport(jasper.getPath(), params, conexion);
            HttpServletResponse hsr = (HttpServletResponse) ec.getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=Detalle Sede.pdf");
            ServletOutputStream os = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.flush();
            os.close();
            fc.responseComplete();
        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

}
