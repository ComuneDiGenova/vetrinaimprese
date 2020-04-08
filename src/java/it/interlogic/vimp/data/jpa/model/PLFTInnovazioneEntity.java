package it.interlogic.vimp.data.jpa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PLF_T_INNOVAZIONE")
// Define named queries here
@NamedQueries({ @NamedQuery(name = "PLFTInnovazioneEntity.countAll", query = "SELECT COUNT(x) FROM PLFTInnovazioneEntity x") })
public class PLFTInnovazioneEntity implements Serializable, TranslatableCodifica
{

	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@Column(name = "ID", nullable = false)
	private BigDecimal id;

	// ----------------------------------------------------------------------
	// ENTITY DATA FIELDS
	// ----------------------------------------------------------------------

	@Column(name = "CODICE", nullable = false, length = 10)
	private String codice;

	@Column(name = "DESCRIZIONE", nullable = false, length = 255)
	private String descrizione;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INIZIO", nullable = false)
	private Date dataInizio;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FINE")
	private Date dataFine;
	
	
	//bi-directional many-to-many association to PLFImpresa
		@ManyToMany
		@JoinTable(
			name="PLF_R_IMPRESA_INNOVAZIONE"
			, joinColumns={
				@JoinColumn(name="ID")
				}
			, inverseJoinColumns={
				@JoinColumn(name="ID_PLF_IMPRESA")
				}
			)
		private List<PLFImpresaEntity> plfImpresas;

		//bi-directional many-to-many association to PLFRichiestaAccreditamento
		@ManyToMany
		@JoinTable(
			name="PLF_R_ACCREDITAMENTO_INNOVAZIONE"
			, joinColumns={
				@JoinColumn(name="ID")
				}
			, inverseJoinColumns={
				@JoinColumn(name="ID_RICHIESTA_ACCREDITAMENTO")
				}
			)
		private List<PLFRichiestaAccreditamentoEntity> plfRichiestaAccreditamentos;


	// ----------------------------------------------------------------------
	// ENTITY LINKS ( RELATIONSHIP )
	// ----------------------------------------------------------------------

	// ----------------------------------------------------------------------
	// CONSTRUCTOR(S)
	// ----------------------------------------------------------------------
	public PLFTInnovazioneEntity()
	{
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER & SETTER FOR THE KEY FIELD
	// ----------------------------------------------------------------------

	@Override
	public BigDecimal getId()
	{
		return id;
	}

	@Override
	public void setId(BigDecimal id)
	{
		this.id = id;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR FIELDS
	// ----------------------------------------------------------------------
	
	@Override
	public String getCodice()
	{
		return codice;
	}

	@Override
	public void setCodice(String codice)
	{
		this.codice = codice;
	}

	public String getDescrizione()
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}

	public Date getDataInizio()
	{
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio)
	{
		this.dataInizio = dataInizio;
	}

	public Date getDataFine()
	{
		return dataFine;
	}

	public void setDataFine(Date dataFine)
	{
		this.dataFine = dataFine;
	}

	// ----------------------------------------------------------------------
	// GETTERS & SETTERS FOR LINKS
	// ----------------------------------------------------------------------
	

	public List<PLFImpresaEntity> getPlfImpresas() {
		return this.plfImpresas;
	}

	public void setPlfImpresas(List<PLFImpresaEntity> plfImpresas) {
		this.plfImpresas = plfImpresas;
	}

	public List<PLFRichiestaAccreditamentoEntity> getPlfRichiestaAccreditamentos() {
		return this.plfRichiestaAccreditamentos;
	}

	public void setPlfRichiestaAccreditamentos(List<PLFRichiestaAccreditamentoEntity> plfRichiestaAccreditamentos) {
		this.plfRichiestaAccreditamentos = plfRichiestaAccreditamentos;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString()
	{
		return "PLFTInnovazioneEntity [id=" + id + ", codice=" + codice + ", descrizione=" + descrizione + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + "]";
	}

}