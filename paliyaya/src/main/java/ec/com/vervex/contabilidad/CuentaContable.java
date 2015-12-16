/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.vervex.contabilidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author chrisvv
 */
@Entity
public class CuentaContable implements Serializable,Comparable<CuentaContable>{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @NotNull
    @ManyToOne
    protected Entidad entidad;
    @NotNull
    protected String codigo;
    @NotNull
    protected String descripcion;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal debe;
    @Column(columnDefinition = "decimal(18,2)")
    protected BigDecimal haber;
    @OneToMany
    protected Set<CuentaContable>subCuentas;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    protected GrupoCuenta grupo;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaContable)) {
            return false;
        }
        CuentaContable other = (CuentaContable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.vervex.contabilidad.CuentaContable[ id=" + id + " ]";
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }

    @Override
    public final int compareTo(CuentaContable o) {
       int retorno=entidad.compareTo(o.entidad);
       if(retorno==0){
           retorno=codigo.compareTo(o.codigo);
       }
       return retorno;
    }

    public Set<CuentaContable> getSubCuentas() {
        return subCuentas;
    }

    public void setSubCuentas(Set<CuentaContable> subCuentas) {
        this.subCuentas = subCuentas;
    }

    public GrupoCuenta getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoCuenta grupo) {
        this.grupo = grupo;
    }
    
}
