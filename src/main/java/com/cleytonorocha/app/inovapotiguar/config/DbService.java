package com.cleytonorocha.app.inovapotiguar.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import com.cleytonorocha.app.inovapotiguar.model.Enum.InstituicaoCategoria;
import com.cleytonorocha.app.inovapotiguar.model.Enum.PesquisaCategoria;
import com.cleytonorocha.app.inovapotiguar.model.Enum.ProcessoEmpreendedor;
import com.cleytonorocha.app.inovapotiguar.model.Enum.UF;
import com.cleytonorocha.app.inovapotiguar.model.entity.Atuacao;
import com.cleytonorocha.app.inovapotiguar.model.entity.EnderecoEvento;
import com.cleytonorocha.app.inovapotiguar.model.entity.Evento;
import com.cleytonorocha.app.inovapotiguar.model.entity.EventoImagens;
import com.cleytonorocha.app.inovapotiguar.model.entity.Ingresso;
import com.cleytonorocha.app.inovapotiguar.model.entity.Instituicao;
import com.cleytonorocha.app.inovapotiguar.model.entity.Pesquisa;
import com.cleytonorocha.app.inovapotiguar.model.entity.Pesquisador;
import com.cleytonorocha.app.inovapotiguar.reporsitory.AtuacaoRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.EventoImagensRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.EventoRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.IngressoRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.InstituicaoRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.PesquisaRepository;
import com.cleytonorocha.app.inovapotiguar.reporsitory.PesquisadorRepository;
import com.cleytonorocha.app.inovapotiguar.util.EnumUtils;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DbService {

    private final EventoRepository eventoRepository;
    private final PesquisaRepository pesquisaRepository;
    private final EventoImagensRepository eventoImagensRepository;
    private final InstituicaoRepository instituicaoRepository;
    private final PesquisadorRepository pesquisadorRepository;
    private final AtuacaoRepository atuacaoRepository;
    private final IngressoRepository ingressoRepository;

    private Faker faker = new Faker(Locale.US);

    @SuppressWarnings("unused")
    public void injetarEventoRepository() {
        List<Long> imagensId = eventoImagensRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> pesquisasId = pesquisaRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> instituicoesId = instituicaoRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> pesquisadoresId = pesquisadorRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> atuacoesId = atuacaoRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> ingressosId = ingressoRepository.findAll().stream().map(m -> m.getId()).toList();
        List<Long> eventosId = eventoRepository.findAll().stream().map(m -> m.getId()).toList();

        List<Evento> eventos = eventoRepository.findAllById(eventosId);
        List<EventoImagens> imagens = eventoImagensRepository.findAllById(imagensId);
        List<Pesquisa> pesquisas = pesquisaRepository.findAllById(pesquisasId);
        List<Instituicao> instituicoes = instituicaoRepository.findAllById(instituicoesId);
        List<Pesquisador> pesquisadores = pesquisadorRepository.findAllById(pesquisadoresId);
        List<Atuacao> atuacoes = atuacaoRepository.findAllById(atuacoesId);
        List<Ingresso> ingressos = ingressoRepository.findAllById(ingressosId);

        Evento evento = eventoRepository.save(evento(pesquisas, imagens, instituicoes, pesquisadores, atuacoes));
        EventoImagens imagem = eventoImagensRepository.save(imagens(evento));
        Pesquisa pesquisa = pesquisaRepository.save(pesquisas(evento, eventos, instituicoes, pesquisadores));
        Instituicao instituicao = instituicaoRepository.save(instituicao(evento, pesquisas, atuacoes));
        Pesquisador pesquisador = pesquisadorRepository.save(pesquisador(evento, pesquisas, atuacoes));
        Atuacao atuacao = atuacaoRepository.save(atuacao(evento, pesquisadores, instituicoes));
        Ingresso ingresso = ingressoRepository.save(ingresso(evento));

    }

    private Evento evento(List<Pesquisa> pesquisas,
            List<EventoImagens> imagens,
            List<Instituicao> instituicoes,
            List<Pesquisador> pesquisadores,
            List<Atuacao> atuacoes) {
        return Evento.builder()
                .id(null)
                .nome("Cleyton Evento").textoApresentacao("Um evento principal para Cleytons")
                .texto(faker.lorem().characters(400))
                .processoEmpreendedor(
                        (ProcessoEmpreendedor) EnumUtils.enumAleatorio(ProcessoEmpreendedor.class))
                .dataInicio(LocalDateTime.now())
                .dataFinal(LocalDateTime.now().plusDays(RandomUtils.nextInt(0, 500)))
                .endereco(enderecoEvento())
                .imagens(imagens)
                .pesquisas(pesquisas)
                .instituicoes(instituicoes)
                .pesquisadores(pesquisadores)
                .atuacoes(atuacoes)
                // .ingressos(ingressos)
                .build();
    }

    private Pesquisa pesquisas(Evento evento, List<Evento> eventos, List<Instituicao> instituicoes,
            List<Pesquisador> pesquisadores) {
        return Pesquisa.builder()
                .id(null)
                .nome(faker.lorem().characters(40))
                .texto(faker.lorem().characters(400))
                .fontes(Arrays.asList(faker.internet().url(), faker.internet().url()))
                .visualizacoes(RandomUtils.nextLong())
                .curtidas(RandomUtils.nextLong())
                .categoria((PesquisaCategoria) EnumUtils.enumAleatorio(PesquisaCategoria.class))
                .eventos(eventos)
                .instituicoes(instituicoes)
                .pesquisadores(pesquisadores)
                .build();
    }

    private EnderecoEvento enderecoEvento() {
        return EnderecoEvento.builder()
                .CEP(faker.address().zipCode())
                .pais(faker.address().country())
                .UF((UF) EnumUtils.enumAleatorio(UF.class))
                .cidade(faker.address().city())
                .bairro(faker.address().cityName())
                .rua(faker.address().streetAddress())
                .build();
    }

    private EventoImagens imagens(Evento evento) {
        return EventoImagens.builder()
                .id(null)
                .url(faker.company().url())
                .evento(evento)
                .build();
    }

    private Instituicao instituicao(Evento evento, List<Pesquisa> pesquisas, List<Atuacao> atuacoes) {
        return Instituicao.builder()
                .id(null)
                .CNPJ(RandomStringUtils.randomNumeric(14))
                .nome(faker.company().name())
                .descricao(faker.company().industry())
                .email(faker.internet()
                        .emailAddress(evento.getNome()
                                .toLowerCase()
                                .replace(" ", "")))
                .categoria((InstituicaoCategoria) EnumUtils.enumAleatorio(InstituicaoCategoria.class))
                .site(faker.company().url())
                .linkedin(faker.internet().url())
                .instagram(faker.internet().avatar())
                .eventos(Arrays.asList(evento))
                .pesquisas(pesquisas)
                .atuacoes(atuacoes)
                .build();
    }

    private Pesquisador pesquisador(Evento evento, List<Pesquisa> pesquisas, List<Atuacao> atuacoes) {
        return Pesquisador.builder()
                .id(null)
                .CPF(RandomStringUtils.randomNumeric(11))
                .nome(faker.name().fullName())
                .cargo(faker.company().profession())
                .email(faker.internet()
                        .emailAddress(evento.getNome()
                                .toLowerCase()
                                .replace(" ", "")))
                .telefone(faker.phoneNumber().cellPhone())
                .descricao(faker.company().industry())
                .fotoPerfil(faker.avatar().image())
                .site(faker.company().url())
                .linkedin(faker.company().url())
                .instagram(faker.company().url())
                .twitter(faker.company().url())
                .eventos(Arrays.asList(evento))
                .pesquisas(pesquisas)
                .atuacoes(atuacoes)
                .build();
    }

    private Atuacao atuacao(Evento evento, List<Pesquisador> pesquisadores, List<Instituicao> instituicoes) {
        return Atuacao.builder()
                .id(null)
                .nome(faker.programmingLanguage().name())
                .descricao(faker.company().industry())
                .eventos(Arrays.asList(evento))
                .instituicoes(instituicoes)
                .pesquisadores(pesquisadores)
                .build();
    }

    private Ingresso ingresso(Evento evento) {
        return Ingresso.builder()
                .id(null)
                .QRcode(RandomStringUtils.random(20))

                // .pagamento(pagamento)
                // .evento()
                .build();
    }

}