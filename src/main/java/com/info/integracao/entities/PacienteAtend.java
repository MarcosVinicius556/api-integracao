/*
 * Created on 31/07/2006 15:52:02
 * 
 * History
 * =======
 *    Date    Description
 * ---------- ----------------------------------------------------------------------------
 * 23/09/2008 inclusão de atributos: locColCompl, taxaExtra
 * 06/02/2008 inclusão do atributo soroteca :u:Wagner
 * 10/12/2007 inclusão do atributo descErroTiss :u:Wagner
 * 06/12/2006 incluído campo obs   :u:douglas
 * 20/06/2007 incluído campo dataEmiResultado (Protocolo de Entrega)   :u:anderson
 * 24/09/2007 exclusão dos atributos data e hora :u:Wagner
 * 25/09/2007 inclusão dos atributos descricaoPacLog, descricaoPacLogModified, newRecord :u:Wagner
 * 03/10/2007 inclusão dos atributos usuDesc e quantExames para Relatório de Controle de Atendimentos :u:Wagner
 * 08/10/2007 criado o método addNumExames :u:Wagner
 * 18/10/2007 adicionado construtor com o Convênio --> PacienteAtend(PacienteAtend pae, Convenio c) :u:Anderson
 * 12/11/2007 adicionado os atributos idRemessaTISS, validadeCart e codPlano :u:Wagner
 */
package br.com.is.isenterprise.lab.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.is.commons.db.model.DataObject;
import br.com.is.commons.db.sql.SQLExpression;
import br.com.is.commons.util.NumberUtil;
import br.com.is.commons.util.StringUtil;
import br.com.is.isenterprise.lab.bo.PacienteAtendExameFull;

/**
 * @author Anderson Palhano (Infoarte Software)
 * @version 1.0
 */
public class PacienteAtend extends DataObject {

	private PacienteAtendId cid;

	private GregorianCalendar dataAtend;

	private String horaAtend;

	private String usuId;

	private int locColCod;
	
	private String locColCompl;

	private String solicCod;

	private String postoCod;
	
	private String serieAmostra;

	private int numContrAmostra;
	
	private int locEntCod;

	private GregorianCalendar dataEntResultado;

	private String horaEntResultado;

	private int formaEntregaPaciente;

	private int formaEntregaSolic;

	private int idRemessaNet;
	
	private BigDecimal vlrTotalExames;
	
	private BigDecimal vlrTotalDescontos; 

	private BigDecimal vlrSaldo;
	
	private BigDecimal taxaExtra;

	private BigDecimal peso;

	private BigDecimal altura;
	
	private String idade;

	private String presSanguinea;

	private GregorianCalendar dataUltMenst;

	private int tempoGest;
	
	private String obs;
	
	private Paciente paciente;
	
	private Convenio convenio;
	
	private StringBuilder descConvenios;
	
	private PostoAtendimento postoAtendimento;
	
	private String pacNome;
	
	private String solicNome;
	
	private String postoNome;
	
	private GregorianCalendar dataNasc;
	
	private String usuDesc;
	
	private String exames;
	
	private String exameCod;
	
	private int sexo;
	
	private String descErroTiss;
	
	private String soroteca;
	
	private GregorianCalendar dataImpResultado; //Campo usado no relatório de Protolo de entrega
	
	private boolean protocoloImpresso; //Campo usado no relatório de Protolo de entrega
	
	private String telefone; //Usado no relatorio de atendimentos

	private String celular;  // Usado no relatório de atendimentos
	
	private BigDecimal vlrRecebido; //Campo utilizado no relatorio diário para conferências
	
	private BigDecimal vlrCobrado; //Campo utilizado no relatorio diário para conferências
	
	private List<PacienteAtendConvenios> pacienteAtendConveniosList;
	
	private boolean pacienteAtendConveniosListModified;
	
	private List<PacienteAtendConvenios> pacienteAtendConveniosListTemp;
	
	private boolean pacienteAtendConveniosListModifiedTemp;
	
	private List<PacienteAtendExame> pacienteAtendExameList;
	
	private List<PacienteAtendExameFull> pacienteAtendExameListFull;
	
	private boolean pacienteAtendExameListModified;
	
	private String remessaNetPdfNome;
	
	private String descricaoPacLog;
	
	private boolean descricaoPacLogModified;
	
	private int tipoFechamento;
	
	private boolean newRecord;
	
	private int impDataUsu;
	
	private String liberadoPor;
	
	private List<Solicitante> bioquimicoList;
	
	private List<RetornoExameTemp> retornoExameTempList;
	
	private List<TaxaExtraAtendimento> taxaExtraAtendList;
	
	private boolean isAgendamento;
	
	private boolean telaAtendimento;

	private PacienteAtendConvenios pacienteAtendConvenio = null;

	//utilizado no relatorio diario.
	private String convenioCodigos;

	// Utilizado no interfacemaento(Tela Importar)
	private String codigoBarrasColeta;
	
	private Solicitante solicitante = null;
	private String munNome;
	
	private GregorianCalendar dataEntResultadoUrgente;
	private String horaEntResultadoUrgente;
	private long tempoEspera;
	private String horaColeta;
	private int enviaInternet;
	private long idPacienteAtend;
	private List<PacienteAtendPagamento> listPacienteAtendPagamento;
	private List<PacienteDoenca> listPacienteDoenca;
	private PacienteAtendDadosClinicos pacienteAtendDadosClinicos;
	
	

	public PacienteAtend() {
		cid = new PacienteAtendId();
		dataAtend = null;
		horaAtend = "";
		usuId = "";
		locColCod = 0;
		locColCompl = "";
		solicCod = "";
		postoCod = "";
		telaAtendimento = false;
		serieAmostra = "";
		numContrAmostra = 0;
		locEntCod = 0;
		dataEntResultado = null;
		horaEntResultado = "";
		formaEntregaPaciente = 0;
		formaEntregaSolic = 0;
		idRemessaNet = -1;
		vlrTotalExames = NumberUtil.BIG_DECIMAL_ZERO;
		vlrTotalDescontos = NumberUtil.BIG_DECIMAL_ZERO;
		vlrSaldo = NumberUtil.BIG_DECIMAL_ZERO;
		taxaExtra = NumberUtil.BIG_DECIMAL_ZERO;
		peso = NumberUtil.BIG_DECIMAL_ZERO3;
		altura = NumberUtil.BIG_DECIMAL_ZERO;
		idade = "";
		presSanguinea = "";
		dataUltMenst = null;
		tempoGest = 0;
		obs = "";
		paciente = null;
		convenio = null;
		postoAtendimento = null;
		pacNome = "";
		solicNome = "";
		postoNome = "";
		dataNasc = null;
		dataImpResultado = null;
		protocoloImpresso = false;
		telefone = "";
		celular = "";
		vlrRecebido = NumberUtil.BIG_DECIMAL_ZERO;
		vlrCobrado = NumberUtil.BIG_DECIMAL_ZERO;
		pacienteAtendConveniosList = null;
		pacienteAtendConveniosListModified = false;
		pacienteAtendConveniosListTemp = null;
		pacienteAtendConveniosListModifiedTemp = false;
		pacienteAtendExameList = null;
		pacienteAtendExameListModified = false;
		descricaoPacLog = "";
		descricaoPacLogModified = false;
		newRecord = false;
		usuDesc = "";
		exames = "";
		sexo = 0;
		descErroTiss = "";
		soroteca = "";
		tipoFechamento = 0;
		impDataUsu  = 0;
		exameCod = "";
		liberadoPor = "";
		convenioCodigos = "";
		codigoBarrasColeta = "";
		isAgendamento = false;
		pacienteAtendConvenio = null;
		solicitante = null;
		dataEntResultadoUrgente = null;
		horaEntResultadoUrgente = "";
		enviaInternet = 0;
		idPacienteAtend = 0;
		versao = -1;
		sel = false;
	}
	
	public PacienteAtend(PacienteAtend pa) {
		pa.copyInto(this);
	}
	
	public PacienteAtend(String exameCod, PacienteAtend pa) {
		pa.copyInto(this);
		this.exameCod = exameCod;
	}
	
	public PacienteAtend(PacienteAtend pa, Convenio c) {
		pa.copyInto(this);
		this.convenio = c;
	}

	public PacienteAtend(PacienteAtend pa, String pacNome) {
		pa.copyInto(this);
		this.pacNome = pacNome;
	}
	
	public PacienteAtend(PacienteAtend pa, String pacNome, String postoNome) {
		pa.copyInto(this);
		this.pacNome = pacNome;
		this.postoNome = postoNome;
	}
	public PacienteAtend(PacienteAtend pa, Paciente p) {
		pa.copyInto(this);
		this.paciente = p;
	}
	
	public PacienteAtendId getCid() {
		return cid;
	}
	
	public GregorianCalendar getDataAtend() {
		return dataAtend;
	}

	public String getHoraAtend() {
		return horaAtend;
	}
	
	public String getUsuId() {
		return usuId;
	}

	public int getLocColCod() {
		return locColCod;
	}
	
	public String getLocColCompl() {
		return locColCompl;
	}

	public String getSolicCod() {
		return solicCod;
	}

	public String getExameCod() {
		return exameCod;
	}

	public String getPostoCod() {
		return postoCod;
	}
	
	public String getSerieAmostra() {
		return serieAmostra;
	}

	public int getNumContrAmostra() {
		return numContrAmostra;
	}
	
	public int getLocEntCod() {
		return locEntCod;
	}

	public GregorianCalendar getDataEntResultado() {
		return dataEntResultado;
	}

	public String getHoraEntResultado() {
		return horaEntResultado;
	}

	public int getFormaEntregaPaciente() {
		return formaEntregaPaciente;
	}

	public int getFormaEntregaSolic() {
		return formaEntregaSolic;
	}

	public int getIdRemessaNet() {
		return idRemessaNet;
	}

	public BigDecimal getVlrTotalExames() {
		return vlrTotalExames;
	}
	
	public BigDecimal getVlrTotalDescontos() {
		return vlrTotalDescontos;
	}

	public BigDecimal getVlrSaldo() {
		return vlrSaldo;
	}
	
	public BigDecimal getTaxaExtra() {
		return taxaExtra;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public String getIdade() {
		return idade;
	}
	
	public String getPresSanguinea() {
		return presSanguinea;
	}

	public GregorianCalendar getDataUltMenst() {
		return dataUltMenst;
	}

	public int getTempoGest() {
		return tempoGest;
	}
	
	public String getObs() {
		return obs;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public Convenio getConvenio() {
		return convenio;
	}
	
	public String getDescConvenios() {
		return descConvenios.toString();
	}
	
	public PostoAtendimento getPostoAtendimento() {
		return postoAtendimento;
	}
	
	public String getPacNome() {
		return pacNome;
	}
	
	public String getSolicNome() {
		return solicNome;
	}
	
	public String getPostoNome() {
		return postoNome;
	}
	
	public GregorianCalendar getDataNasc() {
		return dataNasc;
	}
	
	public int getSexo(){
		return sexo;
	}
	
	public String getDescErroTiss(){
		return descErroTiss;
	}

	public String getSoroteca(){
		return soroteca;
	}
	
	public GregorianCalendar getDataImpResultado() {
		return dataImpResultado;
	}
	
	public boolean isProtocoloImpresso() {
		return protocoloImpresso;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}
	
	public BigDecimal getVlrRecebido() {
		return vlrRecebido;
	}
	
	public BigDecimal getVlrCobrado() {
		return vlrCobrado;
	}
	
	public String getConvenioCodigos() {
		return convenioCodigos;
	}

	public void setConvenioCodigos(String convenioCodigos) {
		this.convenioCodigos = convenioCodigos;
	}
	
	public String getCodigoBarrasColeta() {
		return codigoBarrasColeta;
	}
	public void setCodigoBarrasColeta(String codigoBarrasColeta) {
		this.codigoBarrasColeta = codigoBarrasColeta;
	}
	
	public List<PacienteAtendConvenios> getPacienteAtendConveniosList() {
		if (this.pacienteAtendConveniosList == null) {
			this.pacienteAtendConveniosList = new ArrayList<PacienteAtendConvenios>();
		}
		return this.pacienteAtendConveniosList;
	}
	
	public boolean isPacienteAtendConveniosListModified() {
		return this.pacienteAtendConveniosListModified;
	}
	
	public List<PacienteAtendConvenios> getPacienteAtendConveniosListTemp() {
		if (this.pacienteAtendConveniosListTemp == null) {
			this.pacienteAtendConveniosListTemp = new ArrayList<PacienteAtendConvenios>();
		}
		return this.pacienteAtendConveniosListTemp;
	}
	
	public boolean isPacienteAtendConveniosListModifiedTemp() {
		return this.pacienteAtendConveniosListModifiedTemp;
	}

	
	public List<PacienteAtendExameFull> getPacienteAtendExameListFull() {
		if (this.pacienteAtendExameListFull == null) {
			this.pacienteAtendExameListFull = new ArrayList<PacienteAtendExameFull>();
		}
		return this.pacienteAtendExameListFull;
	}
	
	public List<PacienteAtendExame> getPacienteAtendExameList() {
		if (this.pacienteAtendExameList == null) {
			this.pacienteAtendExameList = new ArrayList<PacienteAtendExame>();
		}
		return this.pacienteAtendExameList;
	}
	public boolean isPacienteAtendExameListModified() {
		return this.pacienteAtendExameListModified;
	}
	
	public String getRemessaNetPdfNome() {
		return remessaNetPdfNome;
	}

	public String getDescricaoPacLog(){
		return descricaoPacLog;
	}
	
	public boolean isDescricaoPacLogModified(){
		return descricaoPacLogModified;
	}

	public boolean isNewRecord(){
		return newRecord;
	}
	
	public String getUsuDesc(){
		return usuDesc;
	}
	
	public String getExames(){
		return exames;
	}
	
	public int getTipoFechamento() {
		return tipoFechamento;
	}
	
	public int getImpDataUsu() {
		return impDataUsu;
	}
	
	public String getLiberadoPor() {
		return liberadoPor;
	}
	
	public boolean isAgendamento() {
		return isAgendamento;
	}
	
	public boolean isTelaAtendimento() {
		return telaAtendimento;
	}

	public void setTelaAtendimento(boolean telaAtendimento) {
		this.telaAtendimento = telaAtendimento;
	}

	public void setAgendamento(boolean isAgendamento) {
		this.isAgendamento = isAgendamento;
	}

	
	public void setLiberadoPor(String liberadoPor) {
		this.liberadoPor = liberadoPor;
	}
	
	public void setCid(PacienteAtendId v) {
		cid = v;
	}

	public void setDataAtend(GregorianCalendar v) {
		dataAtend = v;
	}

	public void setHoraAtend(String v) {
		horaAtend = v;
	}
	
	public void setUsuId(String v) {
		usuId = v;
	}

	public void setLocColCod(int v) {
		locColCod = v;
	}
	
	public void setLocColCompl(String v) {
		locColCompl = v;
	}

	public void setSolicCod(String v) {
		solicCod = v;
	}
	
	public void setExameCod(String v) {
		exameCod = v;
	}

	public void setPostoCod(String v) {
		postoCod = v;
	}
	
	public void setSerieAmostra(String v) {
		serieAmostra = v;
	}

	public void setNumContrAmostra(int v) {
		numContrAmostra = v;
	}
	
	public void setLocEntCod(int v) {
		locEntCod = v;
	}

	public void setDataEntResultado(GregorianCalendar v) {
		dataEntResultado = v;
	}

	public void setHoraEntResultado(String v) {
		horaEntResultado = v;
	}

	public void setFormaEntregaPaciente(int v) {
		formaEntregaPaciente = v;
	}

	public void setFormaEntregaSolic(int v) {
		formaEntregaSolic = v;
	}

	public void setIdRemessaNet(int v) {
		idRemessaNet = v;
	}

	public void setVlrTotalExames(BigDecimal v) {
		vlrTotalExames = v;
	}
	
	public void setVlrTotalDescontos(BigDecimal v) {
		vlrTotalDescontos = v;
	}

	public void setVlrSaldo(BigDecimal v) {
		vlrSaldo = v;
	}
	
	public void setTaxaExtra(BigDecimal v) {
		taxaExtra = v;
	}

	public void setPeso(BigDecimal v) {
		peso = v;
	}

	public void setAltura(BigDecimal v) {
		altura = v;
	}

	public void setIdade(String v) {
		idade = v;
	}
	
	public void setPresSanguinea(String v) {
		presSanguinea = v;
	}

	public void setDataUltMenst(GregorianCalendar v) {
		dataUltMenst = v;
	}

	public void setTempoGest(int v) {
		tempoGest = v;
	}
	
	public void setObs(String v) {
		obs = v;
	}
	
	public void setPaciente(Paciente v) {
		paciente = v;
	}
	
	public void setConvenio(Convenio v) {
		convenio = v;
	}
	
	public void addDescConvenios(String v) {
		if (descConvenios == null)
			descConvenios = new StringBuilder();
		if (StringUtil.isNotEmpty(descConvenios.toString())) {
			descConvenios.append('/');
		}
		descConvenios.append(v);
	}
	
	
	public void setPostoAtendimento(PostoAtendimento v) {
		postoAtendimento = v;
	}
	
	public void setPacNome(String v) {
		pacNome = v;
	}
	
	public void setSolicNome(String v) {
		solicNome = v;
	}
	
	public void setPostoNome(String v) {
		postoNome = v;
	}
	
	public void setDataNasc(GregorianCalendar v) {
		dataNasc = v;
	}
	
	public void setDataImpResultado(GregorianCalendar v) {
		dataImpResultado = v;
	}
	
	public void setProtocoloImpresso(boolean protocoloImpresso) {
		this.protocoloImpresso = protocoloImpresso;
	}
	
	public void setTelefone(String v) {
		telefone = v;
	}

	public void setCelular(String v) {
		celular = v;
	}
	
	public void setVlrRecebido(BigDecimal v) {
		vlrRecebido = v;
	}
	
	public void setVlrCobrado(BigDecimal v) {
		vlrCobrado = v;
	}
	
	public void setPacienteAtendConveniosList(List<PacienteAtendConvenios> pacienteAtendConveniosList) {
		this.pacienteAtendConveniosList = pacienteAtendConveniosList;
	}
	
	public void setPacienteAtendConveniosListModified(boolean exameCodigoListModified) {
		this.pacienteAtendConveniosListModified = exameCodigoListModified;
	}
	
	public void setPacienteAtendConveniosListTemp(List<PacienteAtendConvenios> pacienteAtendConveniosList) {
		this.pacienteAtendConveniosListTemp = pacienteAtendConveniosList;
	}
	
	public void setPacienteAtendConveniosListModifiedTemp(boolean exameCodigoListModified) {
		this.pacienteAtendConveniosListModifiedTemp = exameCodigoListModified;
	}
	
	public void setPacienteAtendExameList(List<PacienteAtendExame> pacienteAtendExameList) {
		this.pacienteAtendExameList = pacienteAtendExameList;
	}
	
	public void setPacienteAtendExameListModified(boolean exameCodigoListModified) {
		this.pacienteAtendExameListModified = exameCodigoListModified;
	}
	
	public void setRemessaNetPdfNome(String v) {
		remessaNetPdfNome = v;
	}
	
	public void setDescricaoPacLog(String v){
		descricaoPacLog = v;
	}
	
	public void setDescricaoPacLogModified(boolean b){
		descricaoPacLogModified = b;
	}

	public void setNewRecord(boolean b){
		newRecord = b;
	}
	
	public void setUsuDesc(String u){
		usuDesc = u;
	}
	
	public void setExames(String q){
		exames = q;
	}
	
	public void setSexo(int v){
		sexo = v;
	}
	
	public Integer getEmpCod() {
		return cid.getEmpCod();
	}

	public Integer getPacCod() {
		return cid.getPacCod();
	}

	public Integer getNumSeqAtend() {
		return cid.getNumSeqAtend();
	}


	public void setEmpCod(Integer v) {
		cid.setEmpCod(v);
	}

	public void setPacCod(Integer v) {
		cid.setPacCod(v);
	}

	public void setNumSeqAtend(Integer v) {
		cid.setNumSeqAtend(v);
	}

	public void setDescErroTiss(String v){
		this.descErroTiss = v;
	}
	
	public void setTipoFechamento(int v) {
		tipoFechamento = v;
	}

	public void setSoroteca(String v){
		this.soroteca = v;
	}
	public void setImpDataUsu(int v){
		this.impDataUsu = v;
	}
	
	public int getEnviaInternet() {
		return enviaInternet;
	}

	public void setEnviaInternet(int enviaInternet) {
		this.enviaInternet = enviaInternet;
	}
	
	public long getIdPacienteAtend() {
		return idPacienteAtend;
	}

	public void setIdPacienteAtend(long idPacienteAtend) {
		this.idPacienteAtend = idPacienteAtend;
	}
	
	public List<PacienteAtendPagamento> getListPacienteAtendPagamento() {
		return listPacienteAtendPagamento;
	}

	public void setListPacienteAtendPagamento(List<PacienteAtendPagamento> listPacienteAtendPagamento) {
		this.listPacienteAtendPagamento = listPacienteAtendPagamento;
	}
	
	public List<PacienteDoenca> getListPacienteDoenca() {
		if (listPacienteDoenca == null) {
			listPacienteDoenca = new ArrayList<PacienteDoenca>();
		}
		return listPacienteDoenca;
	}

	public void setListPacienteDoenca(List<PacienteDoenca> listPacienteDoenca) {
		this.listPacienteDoenca = listPacienteDoenca;
	}
	
	public PacienteAtendDadosClinicos getPacienteAtendDadosClinicos() {
		return pacienteAtendDadosClinicos;
	}

	public void setPacienteAtendDadosClinicos(PacienteAtendDadosClinicos pacienteAtendDadosClinicos) {
		this.pacienteAtendDadosClinicos = pacienteAtendDadosClinicos;
	}

	public PacienteAtend copy() {
		return copyInto(new PacienteAtend());
	}

	public PacienteAtend copyInto(PacienteAtend obj) {
		obj.setCid(cid.copy());
		obj.setIdPacienteAtend(idPacienteAtend);
		obj.setDataAtend(dataAtend);
		obj.setHoraAtend(horaAtend);
		obj.setUsuId(usuId);
		obj.setLocColCod(locColCod);
		obj.setLocColCompl(locColCompl);
		obj.setSolicCod(solicCod);
		obj.setPostoCod(postoCod);
		obj.setSerieAmostra(serieAmostra);
		obj.setNumContrAmostra(numContrAmostra);
		obj.setLocEntCod(locEntCod);
		obj.setDataEntResultado(dataEntResultado);
		obj.setHoraEntResultado(horaEntResultado);
		obj.setFormaEntregaPaciente(formaEntregaPaciente);
		obj.setFormaEntregaSolic(formaEntregaSolic);
		obj.setIdRemessaNet(idRemessaNet);
		obj.setVlrTotalExames(vlrTotalExames);
		obj.setVlrTotalDescontos(vlrTotalDescontos);
		obj.setVlrSaldo(vlrSaldo);
		obj.setTaxaExtra(taxaExtra);
		obj.setPeso(peso);
		obj.setAltura(altura);
		obj.setIdade(idade);
		obj.setPresSanguinea(presSanguinea);
		obj.setDataUltMenst(dataUltMenst);
		obj.setTempoGest(tempoGest);
		obj.setObs(obs);
		obj.setSoroteca(soroteca);
		obj.setImpDataUsu(impDataUsu);
		obj.setDataEntResultadoUrgente(dataEntResultadoUrgente);
		obj.setHoraEntResultadoUrgente(horaEntResultadoUrgente);
		obj.setVersao(versao);
		obj.setEnviaInternet(enviaInternet);
		return obj;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(cid.toString());
		str.append(", ");
		str.append("ID=").append(idPacienteAtend);
		str.append(", ");
		str.append("Data Atendimento=")
		   .append(dataAtend);
		str.append(", ");
		str.append("Hora Atendimento=")
		   .append(horaAtend);
		str.append(", ");
		str.append("Usuário=")
		   .append(usuId);
		str.append(", ");
		str.append(", ");
		str.append("Local Coleta=")
		   .append(locColCod);
		str.append(", ");
		str.append("Local Coleta Complemento=")
		   .append(locColCompl);
		str.append(", ");
		str.append("Solicitante=")
		   .append(solicCod);
		str.append(", ");
		str.append("Posto=")
		   .append(postoCod);
		str.append(", ");
		str.append("Série Amostra=")
		   .append(serieAmostra);
		str.append(", ");
		str.append("No. Controle Amostra=")
		   .append(numContrAmostra);
		str.append(", ");
		str.append("Local Entrega=")
		   .append(locEntCod);
		str.append(", ");
		str.append("Data Entrega Resultado=")
		   .append(dataEntResultado);
		str.append(", ");
		str.append("Hora Entrega Resultado=")
		   .append(horaEntResultado);
		str.append(", ");
		str.append("Forma Entrega Paciente=")
		   .append(formaEntregaPaciente);
		str.append(", ");
		str.append("Forma Entrega Solicitante=")
		   .append(formaEntregaSolic);
		str.append(", ");
		str.append("Id. Remessa Net=")
		   .append(idRemessaNet);
		str.append(", ");
		str.append("Valor Total Exames=")
		   .append(vlrTotalExames);
		str.append(", ");
		str.append("Valor Total Descontos=")
		   .append(vlrTotalDescontos);
		str.append(", ");
		str.append("Valor Saldo=")
		   .append(vlrSaldo);
		str.append(", ");
		str.append("TaxaExtra=")
		   .append(taxaExtra);
		str.append(", ");
		str.append("Peso=")
		   .append(peso);
		str.append(", ");
		str.append("altura=")
		   .append(altura);
		str.append(", ");
		str.append("idade=")
		   .append(idade);
		str.append(", ");
		str.append("Pressão Sanguínea=")
		   .append(presSanguinea);
		str.append(", ");
		str.append("Data Últ. Menstruação=")
		   .append(dataUltMenst);
		str.append(", ");
		str.append("Tempo Gestação=")
		   .append(tempoGest);
		str.append("Observação=")
		.append(obs);
		str.append(", ");
		str.append("Soroteca=")
		.append(soroteca);
		str.append(", ");
		str.append("Imp. Data e Usuário=")
		.append(impDataUsu);
		str.append(", ");
		str.append("Data Entr. Resultado Urgente=").append(dataEntResultadoUrgente);
		str.append(", ");
		str.append("Hora Entr. Resultado Urgente=").append(horaEntResultadoUrgente);
		str.append(", ");
		str.append("Versão=")
		   .append(versao);
		return str.toString();
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof PacienteAtend)) return false;
		final PacienteAtend other = (PacienteAtend)obj;
		if (!cid.equals(other.cid)) return false;
		return true;
	}

	public int hashCode() {
		int result = cid.hashCode();
		return result;
	}

	public int compareTo(Object obj) {
		if (obj instanceof PacienteAtend) {
			final PacienteAtend other = (PacienteAtend)obj;
			return cid.compareTo(other.cid);
		}
		return 0;
	}

	public String getName() {
		return "Paciente Atendimento";
	}

	public char getGender() {
		return 'm';	}

	public String getSqlIdWhere() {
		SQLExpression sqlExpressions[] = {new SQLExpression("PacienteAtend.empCod", "=", getEmpCod(), "and"),
										  new SQLExpression("PacienteAtend.pacCod", "=", getPacCod(), "and"),
										  new SQLExpression("PacienteAtend.numSeqAtend", "=", getNumSeqAtend(), "")};
		return SQLExpression.createSQLExpression(sqlExpressions);
	}

	public Serializable getDataObjectId() {
		return cid;
	}

	public Class getDataObjectClass() {
		return PacienteAtend.class;
	}
	
	public String getSerieNumAmostraFormatado(){
		return serieAmostra + "/" + numContrAmostra;
	}

	public void addExame(String exame){
		if (StringUtil.isEmpty(exames)) {
			exames = exame;
		} else
			exames = exames + ", " + exame;
	}
	
	public void addPacienteAtendExame(PacienteAtendExame pae) {
		if (pacienteAtendExameList == null) {
			pacienteAtendExameList = new ArrayList<PacienteAtendExame>();
		}
		pacienteAtendExameList.add(pae);
	}
	
	public void addRetornoExameTemp(RetornoExameTemp ret) {
		if (retornoExameTempList == null) {
			retornoExameTempList = new ArrayList<RetornoExameTemp>();
		}
		retornoExameTempList.add(ret);
	}
	
	public void addPacienteAtendExameFull(PacienteAtendExameFull pae) {
		if (pacienteAtendExameListFull == null) {
			pacienteAtendExameListFull = new ArrayList<PacienteAtendExameFull>();
		}
		pacienteAtendExameListFull.add(pae);
	}
	
	public List<Solicitante> getBioquimicoList() {
		return bioquimicoList;
	}
	
	public List<RetornoExameTemp> getRetornoExameTempList() {
		if (this.retornoExameTempList == null) {
			this.retornoExameTempList = new ArrayList<RetornoExameTemp>();
		}
		return this.retornoExameTempList;
	}

	public void setRetornoExameTempList(List<RetornoExameTemp> retornoExameTempList) {
		this.retornoExameTempList = retornoExameTempList;
	}

	public void setBioquimicoList(List<Solicitante> bioquimicoList) {
		this.bioquimicoList = bioquimicoList;
	}
	
	public List<TaxaExtraAtendimento> getTaxaExtraAtendList() {
		return taxaExtraAtendList;
	}

	public void setTaxaExtraAtendList(List<TaxaExtraAtendimento> taxaExtraAtendList) {
		this.taxaExtraAtendList = taxaExtraAtendList;
	}
	
	public PacienteAtendConvenios getPacienteAtendConvenio() {
		return pacienteAtendConvenio;
	}

	public void setPacienteAtendConvenio(
			PacienteAtendConvenios pacienteAtendConvenio) {
		this.pacienteAtendConvenio = pacienteAtendConvenio;
	}
	
	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	
	public GregorianCalendar getDataEntResultadoUrgente() {
		return dataEntResultadoUrgente;
	}
	
	public void setDataEntResultadoUrgente(GregorianCalendar dataEntResultadoUrgente) {
		this.dataEntResultadoUrgente = dataEntResultadoUrgente;
	}
	
	public String getHoraEntResultadoUrgente() {
		return horaEntResultadoUrgente;
	}
	
	public void setHoraEntResultadoUrgente(String horaEntResultadoUrgente) {
		this.horaEntResultadoUrgente = horaEntResultadoUrgente;
	}
	
	public void addTempoEspera() {
		tempoEspera+=2;
	}
	
	public void setTempoEspera(long tempoEspera) {
		this.tempoEspera = tempoEspera;
	}
	
	public String getTempoEspera() {
		long h = tempoEspera/3600;
		long m = tempoEspera/60;
//		long s = tempoEspera%60;
		if (m > 59)
			m -= h*60;
		return h + ":" + m /*+ ":" + s*/;
	}

	public String getHoraColeta() {
		return horaColeta;
	}

	public void setHoraColeta(String horaColeta) {
		this.horaColeta = horaColeta;
	}

	public String getMunNome() {
		return munNome;
	}

	public void setMunNome(String munNome) {
		this.munNome = munNome;
	}

}
