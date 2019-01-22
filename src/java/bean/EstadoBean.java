/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ConsultaCidade;
import dao.ConsultaEstado;
import dao.ConsultaReclamacoes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import modelo.Cidade;
import modelo.Estado;
import modelo.Nome_Lojas;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LegendPlacement;

/**
 *
 * @author nailton viana gloria
 */
@ManagedBean(name = "estadoBean")
@SessionScoped
public class EstadoBean implements Serializable {

    private List<Estado> estados = new ArrayList<Estado>();
    private Cidade cidade = new Cidade();
    private List<Cidade> cidades = new ArrayList<Cidade>();
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    private Estado estado = new Estado();
    private Nome_Lojas lojas = new Nome_Lojas();
    private List<Nome_Lojas> nomes_loja = new ArrayList<Nome_Lojas>();
    private boolean valor2010;
    private boolean valor2011;
    private boolean valor2012;
    private boolean valor2013;
    private boolean valor2014;
    private boolean valor2015;
    private boolean valor2016;
    private boolean valor2017;
    private boolean todo_valores;
    private String loja;
    private String inseri_loja;
    Long sindec2010s = 0L;
    Long sindec2010n = 0L;
    Long sindec2011s = 0L;
    Long sindec2011n = 0L;
    Long sindec2012s = 0L;
    Long sindec2012n = 0L;
    Long sindec2013s = 0L;
    Long sindec2013n = 0L;
    Long sindec2014s = 0L;
    Long sindec2014n = 0L;
    Long sindec2015s = 0L;
    Long sindec2015n = 0L;
    Long sindec2016s = 0L;
    Long sindec2016n = 0L;
    Long reclamacoes2017s = 0L;
    Long reclamacoes2017n = 0L;

    @EJB
    private ConsultaEstado estadoDao;
    @EJB
    private ConsultaCidade cidadeDao;
    @EJB
    private static ConsultaReclamacoes consulta;

    @PostConstruct
    public void init() {
        listarEstado();
        createBarModels();

    }

    public void listarCidade() {
        this.cidades = cidadeDao.getCidades(estado.getUf());

    }

    public List<String> complete(String query) {
        System.out.println("estado " + estado.getUf());
        List<String> results = new ArrayList<String>();
        nomes_loja = consulta.getnome_lojas(estado.getUf(), cidade.getNome(), query.toLowerCase());
        for (Nome_Lojas lojas : nomes_loja) {
            results.add(lojas.getNome());

        }
        return results;

    }

    public void botao() {
        // System.out.println("estado " + estado.getUf() + " cidade " + cidade.getNome() + " loja " + loja);
        if (loja.equalsIgnoreCase("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Alerta !!!", "Insira o nome da loja !!!"));
            sindec2010s = 0L;
            sindec2010n = 0L;
            sindec2011s = 0L;
            sindec2011n = 0L;
            sindec2012s = 0L;
            sindec2012n = 0L;
            sindec2013s = 0L;
            sindec2013n = 0L;
            sindec2014s = 0L;
            sindec2014n = 0L;
            sindec2015s = 0L;
            sindec2015n = 0L;
            sindec2016s = 0L;
            sindec2016n = 0L;
            reclamacoes2017s = 0L;
            reclamacoes2017n = 0L;
            createBarModels();

        } if (valor2010 == false && valor2011 == false && valor2012 == false
                && valor2013 == false && valor2014 == false && valor2015 == false
                && valor2016 == false && valor2017 == false && todo_valores==false) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Aviso !!!", "Selecione qualquer ano para consulta!!!"));

        } else{
            if (valor2010 == true) {
                sindec2010s = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2010n = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                if (sindec2010s == 0 && sindec2010n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2010!!!"));

                } else {
                    sindec2010s = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2010n = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");

                }
                createBarModels();

            } else if (valor2010 == false) {
                sindec2010s = 0L;
                sindec2010n = 0L;
                createBarModels();
            }
            if (valor2011 == true) {
                sindec2011s = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2011n = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                if (sindec2011s == 0 && sindec2011n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2011!!!"));

                } else {
                    sindec2011s = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2011n = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");

                }
                createBarModels();

            } else if (valor2011 == false) {
                sindec2011s = 0L;
                sindec2011n = 0L;
                createBarModels();
            }
            if (valor2012 == true) {
                sindec2012s = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2012n = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                if (sindec2012s == 0 && sindec2012n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2012!!!"));

                } else {
                    sindec2012s = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2012n = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");

                }
                createBarModels();

            } else if (valor2012 == false) {
                sindec2012s = 0L;
                sindec2012n = 0L;
                createBarModels();

            }
            if (valor2013 == true) {
                sindec2013s = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2013n = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                if (sindec2013s == 0 && sindec2013n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2013!!!"));

                } else {
                    sindec2013s = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2013n = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                }
                createBarModels();

            } else if (valor2013 == false) {
                sindec2013s = 0L;
                sindec2013n = 0L;
                createBarModels();

            }
            if (valor2014 == true) {
                Long soma1 = consulta.getReclamacoesbr2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma2 = consulta.getSindec2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                // System.out.println(soma1);
                // System.out.println(soma2);
                Long soma3 = consulta.getReclamacoesbr2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma4 = consulta.getSindec2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                // System.out.println(soma3);
                //System.out.println(soma4);
                sindec2014s = soma1 + soma2;
                sindec2014n = soma3 + soma4;
                if (sindec2014s == 0 && sindec2014n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2014!!!"));
                } else {
                    sindec2014s = soma1 + soma2;
                    sindec2014n = soma3 + soma4;
                }
                createBarModels();

            } else if (valor2014 == false) {
                sindec2014s = 0L;
                sindec2014n = 0L;
                createBarModels();

            }

            if (valor2015 == true) {
                Long soma1 = consulta.getReclamacoesbr2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma2 = consulta.getSindec2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                //System.out.println(soma1);
                //System.out.println(soma2);
                Long soma3 = consulta.getReclamacoesbr2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma4 = consulta.getSindec2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                //System.out.println(soma3);
                //System.out.println(soma4);
                sindec2015s = soma1 + soma2;
                sindec2015n = soma3 + soma4;
                if (sindec2015s == 0 && sindec2015n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2015!!!"));

                } else {
                    sindec2015s = soma1 + soma2;
                    sindec2015n = soma3 + soma4;
                }
                createBarModels();

            } else if (valor2015 == false) {
                sindec2015s = 0L;
                sindec2015n = 0L;
                createBarModels();
            }
            if (valor2016 == true) {
                Long soma1 = consulta.getReclamacoesbr2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma2 = consulta.getSindec2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                //System.out.println(soma1);
                //System.out.println(soma2);
                Long soma3 = consulta.getReclamacoesbr2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma4 = consulta.getSindec2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                //System.out.println(soma3);
                //System.out.println(soma4);
                sindec2016s = soma1 + soma2;
                sindec2016n = soma3 + soma4;
                if (sindec2016s == 0 && sindec2016n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", "a loja " + loja.toLowerCase() + " não contém reclamações no ano de 2016!!!"));
                    //createBarModels();
                } else {
                    sindec2016s = soma1 + soma2;
                    sindec2016n = soma3 + soma4;
                    //createBarModels();
                }
                createBarModels();

            } else if (valor2016 == false) {
                sindec2016s = 0L;
                sindec2016n = 0L;
                createBarModels();
            }
            if (valor2017 == true) {
                reclamacoes2017s = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                reclamacoes2017n = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                if (reclamacoes2017s == 0 && reclamacoes2017n == 0) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém reclamações no ano de 2017!!!"));

                } else {
                    reclamacoes2017s = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    reclamacoes2017n = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                }
                createBarModels();
            } else if (valor2017 == false) {
                reclamacoes2017s = 0L;
                reclamacoes2017n = 0L;
                createBarModels();

            }
            if (todo_valores == true) {
                sindec2010s = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2010n = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2011s = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2011n = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2012s = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2012n = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2013s = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                sindec2013n = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                /*System.out.println(sindec2010s);
                 System.out.println(sindec2010n);
                 System.out.println(sindec2011s);
                 System.out.println(sindec2011n);
                 System.out.println(sindec2012s);
                 System.out.println(sindec2012n);
                 System.out.println(sindec2013s);
                 System.out.println(sindec2013n);*/
                Long soma1 = consulta.getReclamacoesbr2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma2 = consulta.getSindec2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma3 = consulta.getReclamacoesbr2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma4 = consulta.getSindec2014(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2014s = soma1 + soma2;
                sindec2014n = soma3 + soma4;
                /*System.out.println(sindec2014s);
                 System.out.println(sindec2014n);*/
                Long soma5 = consulta.getReclamacoesbr2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma6 = consulta.getSindec2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma7 = consulta.getReclamacoesbr2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma8 = consulta.getSindec2015(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2015s = soma5 + soma6;
                sindec2015n = soma7 + soma8;
                /*System.out.println(sindec2015s);
                 System.out.println(sindec2015n);*/
                Long soma9 = consulta.getReclamacoesbr2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma10 = consulta.getSindec2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                Long soma11 = consulta.getReclamacoesbr2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                Long soma12 = consulta.getSindec2016(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                sindec2016s = soma9 + soma10;
                sindec2016n = soma11 + soma12;
                /*System.out.println(sindec2016s);
                 System.out.println(sindec2016n);*/
                reclamacoes2017s = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                reclamacoes2017n = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                /*System.out.println(reclamacoes2017s);
                 System.out.println(reclamacoes2017n);*/
                if (sindec2010s == 0 && sindec2010n == 0 && sindec2011s == 0
                        && sindec2011n == 0 && sindec2012s == 0 && sindec2012n == 0
                        && sindec2013s == 0 && sindec2013n == 0 && sindec2014s == 0 && sindec2014n == 0
                        && sindec2014s == 0 && sindec2015s == 0 && sindec2015n == 0 && sindec2016s == 0
                        && sindec2016n == 0 && reclamacoes2017s == 0 && reclamacoes2017n == 0) {

                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Aviso !!! ", loja.toLowerCase() + " não contém nenhuma reclamação !!!"));

                } else {

                    sindec2010s = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2010n = consulta.getSindec2010(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                    sindec2011s = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2011n = consulta.getSindec2011(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                    sindec2012s = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2012n = consulta.getSindec2012(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                    sindec2013s = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    sindec2013n = consulta.getSindec2013(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                    /*System.out.println(sindec2010s);
                     System.out.println(sindec2010n);
                     System.out.println(sindec2011s);
                     System.out.println(sindec2011n);
                     System.out.println(sindec2012s);
                     System.out.println(sindec2012n);
                     System.out.println(sindec2013s);
                     System.out.println(sindec2013n);*/
                    sindec2014s = soma1 + soma2;
                    sindec2014n = soma3 + soma4;
                    /*System.out.println(sindec2014s);
                     System.out.println(sindec2014n);*/
                    sindec2015s = soma5 + soma6;
                    sindec2015n = soma7 + soma8;
                    /*System.out.println(sindec2015s);
                     System.out.println(sindec2015n);*/
                    sindec2016s = soma9 + soma10;
                    sindec2016n = soma11 + soma12;
                    /*System.out.println(sindec2016s);
                     System.out.println(sindec2016n);*/
                    reclamacoes2017s = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "S");
                    reclamacoes2017n = consulta.getReclamacoesbr2017(estado.getUf(), cidade.getNome(), loja.toLowerCase(), "N");
                    /*System.out.println(reclamacoes2017s);
                     System.out.println(reclamacoes2017n);*/

                }
                createBarModels();

            }

        }
        loja = null;
        lojas.setNome(null);
    }

    public Cidade consultaCidadeBanco(Long id) {
        return cidadeDao.visualizar(id);
    }

    public void listarEstado() {
        this.estados = estadoDao.listar();

    }

    public void testeDialogo() {
        //System.out.println("entrou no metodo testedialogo");
        if (loja.equalsIgnoreCase("")) {
            //System.out.println("entrou no if loja");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Alerta !!!", "Insira o nome da loja !!!"));
        } else {
            Map<String, Object> options = new HashMap<>();
            options.put("resizable", false);
            options.put("contentHeight", 470);
            PrimeFaces.current().dialog().openDynamic("SelecaoLoja.xhtml", options, null);
            listarLoja();

        }

    }

    public void pegarValorTabela(Nome_Lojas lojas) {
        RequestContext.getCurrentInstance().closeDialog(lojas);
        // System.out.println("esse valor tabela " + lojas.getNome());

    }

    public void nome_lojaSelecionado(SelectEvent event) {
        //System.out.println("entrou no metodo nome_lojaselecionado");
        Nome_Lojas nome_lojas = (Nome_Lojas) event.getObject();
        lojas.setNome(nome_lojas.getNome());
        //System.out.println("entrou no metodo nome_lojas " + nome_lojas.getNome());

    }

    public void listarLoja() {
        //System.out.println("listar loja " + loja);
        this.nomes_loja = consulta.getnome_lojas(estado.getUf(), cidade.getNome(), loja.toLowerCase());
    }

    /*public void testeLoja() {
     System.out.println("printou loja atualizada " + loja);
     }*/
    public Estado consultaEstado(Long id) {

        Estado estado = null;

        //System.out.println("####################### Estado com id: " + id);
        for (Estado e : estados) {

            if (e.getId() == id) {
                estado = e;
            }
        }
        return estado;
    }

    public Cidade consultaCidade(long id) {

        Cidade cidade1 = null;

        //System.out.println("####################### cidade com id: " + id);
        for (Cidade c : cidades) {

            if (c.getId() == id) {
                cidade1 = c;
            }
        }
        return cidade1;
    }

    public void preencher() {
        listarCidade();

    }

    public ConsultaEstado getEstadoDao() {
        return estadoDao;
    }

    public void setEstadoDao(ConsultaEstado estadoDao) {
        this.estadoDao = estadoDao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }

    public void setHorizontalBarModel(HorizontalBarChartModel horizontalBarModel) {
        this.horizontalBarModel = horizontalBarModel;
    }

    public void createBarModels() {
        createBarModel();

    }

    public BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        //System.out.println(resultado2014);

        ChartSeries atendidas = new ChartSeries();
        atendidas.setLabel("Atendidas");
        atendidas.set("2010", sindec2010s);
        atendidas.set("2011", sindec2011s);
        atendidas.set("2012", sindec2012s);
        atendidas.set("2013", sindec2013s);
        atendidas.set("2014", sindec2014s);
        atendidas.set("2015", sindec2015s);
        atendidas.set("2016", sindec2016s);
        atendidas.set("2017", reclamacoes2017s);

        ChartSeries nao = new ChartSeries();
        nao.setLabel("Não atendidas");
        nao.set("2010", sindec2010n);
        nao.set("2011", sindec2011n);
        nao.set("2012", sindec2012n);
        nao.set("2013", sindec2013n);
        nao.set("2014", sindec2014n);
        nao.set("2015", sindec2015n);
        nao.set("2016", sindec2016n);
        nao.set("2017", reclamacoes2017n);

        model.addSeries(atendidas);
        model.addSeries(nao);

        return model;
    }

    public void createBarModel() {
        barModel = initBarModel();
        barModel.setTitle("Reclamações");
        barModel.setLegendPosition("ne");
        barModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
        barModel.setAnimate(true);
        barModel.setMouseoverHighlight(true);
        barModel.setShowPointLabels(true);
        barModel.setShowDatatip(false);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Anos");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setTickFormat("%'.0f");
        yAxis.setLabel("Quantidade de reclamações");
    }

    public void retornaValor() {
        System.out.println("lojas " + inseri_loja);
    }

    public ConsultaCidade getCidadeDao() {
        return cidadeDao;
    }

    public void setCidadeDao(ConsultaCidade cidadeDao) {
        this.cidadeDao = cidadeDao;
    }

    public String getLoja() {
        return lojas.getNome() == null
                ? null : lojas.getNome();
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public boolean isValor2010() {
        return valor2010;
    }

    public void setValor2010(boolean valor2010) {
        this.valor2010 = valor2010;
    }

    public boolean isValor2011() {
        return valor2011;
    }

    public void setValor2011(boolean valor2011) {
        this.valor2011 = valor2011;
    }

    public boolean isValor2012() {
        return valor2012;
    }

    public void setValor2012(boolean valor2012) {
        this.valor2012 = valor2012;
    }

    public boolean isValor2013() {
        return valor2013;
    }

    public boolean isTodo_valores() {
        return todo_valores;
    }

    public void setTodo_valores(boolean todo_valores) {
        this.todo_valores = todo_valores;
    }

    public void setValor2013(boolean valor2013) {
        this.valor2013 = valor2013;
    }

    public boolean isValor2014() {
        return valor2014;
    }

    public void setValor2014(boolean valor2014) {
        this.valor2014 = valor2014;
    }

    public boolean isValor2015() {
        return valor2015;
    }

    public void setValor2015(boolean valor2015) {
        this.valor2015 = valor2015;
    }

    public boolean isValor2016() {
        return valor2016;
    }

    public void setValor2016(boolean valor2016) {
        this.valor2016 = valor2016;
    }

    public boolean isValor2017() {
        return valor2017;
    }

    public void setValor2017(boolean valor2017) {
        this.valor2017 = valor2017;
    }

    public Nome_Lojas getLojas() {
        return lojas;
    }

    public void setLojas(Nome_Lojas lojas) {
        this.lojas = lojas;
    }

    public List<Nome_Lojas> getNomes_loja() {
        return nomes_loja;
    }

    public void setNomes_loja(List<Nome_Lojas> nomes_loja) {
        this.nomes_loja = nomes_loja;
    }

    public String getInseri_loja() {
        return inseri_loja;
    }

    public void setInseri_loja(String inseri_loja) {
        this.inseri_loja = inseri_loja;
    }

}
