package com.info.integracao.config;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.info.integracao.entities.Aparelho;
import com.info.integracao.entities.AparelhoCampos;
import com.info.integracao.entities.AparelhoExame;
import com.info.integracao.entities.AparelhoLog;
import com.info.integracao.repositories.AparelhoCamposRepository;
import com.info.integracao.repositories.AparelhoExameRepository;
import com.info.integracao.repositories.AparelhoLogRepository;
import com.info.integracao.repositories.AparelhoRepository;

@Configuration
public class Config implements CommandLineRunner{

    @Autowired
    private AparelhoRepository apRepository;
    
    @Autowired
    private AparelhoExameRepository apExameRepository;

    @Autowired
    private AparelhoCamposRepository apCamposRepository;

    @Autowired
    private AparelhoLogRepository apLogRepository;

    @Override
    public void run(String... args) throws Exception {
        Aparelho Aparelho_1 = new Aparelho("Aparelho - 1",
                                        "modelo - 1",
                                        "Fabricante - 1",
                                        1,
                                        1,
                                        "192.168.7.12",
                                        12351,
                                        "192.168.0.0",
                                        1212,
                                        null,
                                        0,
                                        0,
                                        0,
                                        0,
                                        null,
                                        null,
                                        1,
                                        1,
                                        1,
                                        1);

        Aparelho Aparelho_2 = new Aparelho("Aparelho - 2",
                                        "modelo - 2",
                                        "Fabricante - 2",
                                        1,
                                        1,
                                        "192.168.7.12",
                                        12351,
                                        null,
                                        0,
                                        "Teste Porta Serial",
                                        60,
                                        10,
                                        10,
                                        10,
                                        null,
                                        null,
                                        1,
                                        0,
                                        3,
                                        2);

        Aparelho Aparelho_3 = new Aparelho("Aparelho - 3",
                                        "modelo - 3",
                                        "Fabricante - 3",
                                        2,
                                        3,
                                        "192.168.7.12",
                                        12351,
                                        null,
                                        0,
                                        null,
                                        0,
                                        0,
                                        0,
                                        0,
                                        "C:/import",
                                        "C:/export",
                                        2,
                                        0,
                                        3,
                                        5);
       
        apRepository.saveAll(List.of(Aparelho_1, Aparelho_2, Aparelho_3));

        AparelhoExame aparelhoExame_1 = new AparelhoExame(Aparelho_1, "HE", "@Add");
        AparelhoExame aparelhoExame_2 = new AparelhoExame(Aparelho_2, "COL", "@Sub");
        AparelhoExame aparelhoExame_3 = new AparelhoExame(Aparelho_3, "GLI", "@Ignore");
       
        apExameRepository.saveAll(List.of(aparelhoExame_1, aparelhoExame_2, aparelhoExame_3));

        AparelhoCampos aparelhoCampos_1 = new AparelhoCampos(aparelhoExame_1, 1, "HE", 1, "vlr_he");
        AparelhoCampos aparelhoCampos_2 = new AparelhoCampos(aparelhoExame_2, 2, "COL", 1, "vlr_col");
        AparelhoCampos aparelhoCampos_3 = new AparelhoCampos(aparelhoExame_3, 3, "GLI", 1, "vlr_gli");
       
        apCamposRepository.saveAll(List.of(aparelhoCampos_1, aparelhoCampos_2, aparelhoCampos_3));

        AparelhoLog aparelhoLog_1 = new AparelhoLog(Aparelho_1, new GregorianCalendar(), "adm", "Inclusão no BD");
        AparelhoLog aparelhoLog_2 = new AparelhoLog(Aparelho_2, new GregorianCalendar(), "teste", "Inclusão no BD");
        AparelhoLog aparelhoLog_3 = new AparelhoLog(Aparelho_3, new GregorianCalendar(), "teste", "Inclusão no BD");

        apLogRepository.saveAll(List.of(aparelhoLog_1, aparelhoLog_2, aparelhoLog_3));

    }
    
}
