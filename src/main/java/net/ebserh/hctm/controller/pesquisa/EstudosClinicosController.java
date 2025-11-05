package net.ebserh.hctm.controller.pesquisa;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import net.ebserh.hctm.model.pesquisa.BolsaProdutividadeCnpq;
import net.ebserh.hctm.model.pesquisa.EstudoClinico;
import net.ebserh.hctm.util.FacesUtils;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named
@ViewScoped
public class EstudosClinicosController implements Serializable {

    private static final Logger logger = Logger.getAnonymousLogger();

    //@Inject
    //private PesquisasService pesquisasService;

    private List<EstudoClinico> estudos = new ArrayList<>();

    private EstudoClinico estudoClinico;

    /*
    @PostConstruct
    public void init() {
        try {
            bolsas = pesquisasService.buscaBolsas();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
    */

    public void openDialogNovo() {
        estudoClinico = new EstudoClinico();
        PrimeFaces.current().executeScript("PF('dialogEstudoClinico').show()");
    }

    public void editaEstudoClinico(EstudoClinico estudoClinico) {
        if (estudoClinico == null) {
            FacesUtils.showError("É necessário selecionar um registro para edição.");
            return;
        }

        this.estudoClinico = estudoClinico;
        PrimeFaces.current().executeScript("PF('dialogEstudoClinico').show()");
    }

    public void salva() {
        estudos = new ArrayList<>();
        estudos.add(estudoClinico);

        PrimeFaces.current().executeScript("PF('dialogEstudoClinico').hide()");
        FacesUtils.showInfo("Em construção...");
    /*
        if (bolsaProdutividadeCnpq == null) {
            FacesUtils.showError("É necessário informar os dados da bolsa.");
            return;
        }

        try {
            pesquisasService.salvaBolsaProdutividade(bolsaProdutividadeCnpq);
            bolsas = pesquisasService.buscaBolsas();
            PrimeFaces.current().executeScript("PF('dialogBolsaProdutividade').hide()");
            FacesUtils.showInfo("Bolsa salva com sucesso!");
        } catch (Exception e) {
            FacesUtils.processaExcecao(e, logger, "Ocorreu um erro ao salvar a bolsa.");
        }
    */
    }

    public String descreveStatus(String status) {
        return switch (status) {
            case "EP" -> "Em planejamento";
            case "EE" -> "Em execução";
            case "ST" -> "Suspenso temporaramente";
            case "CO" -> "Concluído";
            default -> "";
        };
    }

    public List<EstudoClinico> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<EstudoClinico> estudos) {
        this.estudos = estudos;
    }

    public EstudoClinico getEstudoClinico() {
        return estudoClinico;
    }

    public void setEstudoClinico(EstudoClinico estudoClinico) {
        this.estudoClinico = estudoClinico;
    }

}
