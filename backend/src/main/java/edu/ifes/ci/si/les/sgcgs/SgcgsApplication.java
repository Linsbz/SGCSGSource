package edu.ifes.ci.si.les.sgcgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import edu.ifes.ci.si.les.sgcgs.model.*;
import edu.ifes.ci.si.les.sgcgs.repositories.*;

@SpringBootApplication
public class SgcgsApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FormularioRepository formularioRepository;

	@Autowired
	private RespostaFormularioRepository respostaFormularioRepository;

	@Autowired
	private NoticiaRepository noticiaRepository;

	@Autowired
	private PostagemNoticiaRepository PostagemNoticiaRepository;

	@Autowired
	private TemaRepository TemaRepository;

	// @Autowired
	// private CompraTemaRepository CompraTemaRepository;

	@Autowired
	private EnqueteRepository EnqueteRepository;

	@Autowired
	private OpcaoVotoRepository OpcaoVotoRepository;

	@Autowired
	private VotoRepository VotoRepository;

	@Autowired
	private AnuncioRepository AnuncioRepository;

	@Autowired
	private AreaAnuncioRepository AreaAnuncioRepository;

	// @Autowired
	// private PostagemAnuncioRepository PostagemAnuncioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SgcgsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Usuario u1 = new Usuario(null, "Barros", "barros@sgcgs.com.br","1234", 2);
		Usuario u2 = new Usuario(null, "Gaspar", "gaspar@sgcgs.com.br","1234", 0);
		Usuario u3 = new Usuario(null, "Hilda", "hilda@sgcgs.com.br","1234", 0);
		Usuario u4 = new Usuario(null, "Júlia", "julia@sgcgs.com.br","1234", 1);
		Usuario u5 = new Usuario(null, "Lincoln", "lincoln@sgcgs.com.br","1234", 1);
		Usuario u6 = new Usuario(null, "Rafael", "rafael@sgcgs.com.br","1234", 0);
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5, u6));
		
		Formulario f1 = new Formulario(null, "Qual sua opinião sobre o SGCGS?", false, false, u5);
		Formulario f2 = new Formulario(null, "Qual sua opinião sobre o Wix?", true, true, u5);
		
		CampoDeFormulario c1f1 = new CampoDeFormulario(null, "Conhece o SGCGS?", "radio", "{\"options\": [{\"value\":\"s\", \"name\": \"sim\"}, {\"value\":\"n\", \"name\": \"não\"}]}", true, f1);
		CampoDeFormulario c2f1 = new CampoDeFormulario(null, "Já utilizou o SGCGS?", "radio", "{\"options\": [{\"value\":\"s\", \"name\": \"sim\"}, {\"value\":\"n\", \"name\": \"não\"}]}", true, f1);
		
		CampoDeFormulario c1f2 = new CampoDeFormulario(null, "Conhece o Wix?", "radio", "{\"options\": [{\"value\":\"s\", \"name\": \"sim\"}, {\"value\":\"n\", \"name\": \"não\"}]}", true, f2);
		CampoDeFormulario c2f2 = new CampoDeFormulario(null, "Já utilizou o Wix?", "radio", "{\"options\": [{\"value\":\"s\", \"name\": \"sim\"}, {\"value\":\"n\", \"name\": \"não\"}]}", true, f2);
		
		f1.setItens(Arrays.asList(c1f1, c2f1));
        f2.setItens(Arrays.asList(c1f2,c2f2));
		
		formularioRepository.saveAll(Arrays.asList(f1,f2));
		
		RespostaFormulario rf1 = new RespostaFormulario(null, new Date(2022, 5, 20, 1, 42), u2, f2);
		RespostaFormulario rf2 = new RespostaFormulario(null, new Date(2022, 5, 20, 1, 45), u3, f2);
		
		RespostaCampo rc1f1 = new RespostaCampo(null, "Sim", rf1, c1f2);
		RespostaCampo rc2f1 = new RespostaCampo(null, "Sim", rf1, c1f2);

		RespostaCampo rc1f2 = new RespostaCampo(null, "Sim", rf2, c1f2);
		RespostaCampo rc2f2 = new RespostaCampo(null, "Não", rf2, c1f2);		

		rf1.setRespostaCampos(Arrays.asList(rc1f1, rc2f1));
		rf2.setRespostaCampos(Arrays.asList(rc1f2, rc2f2));
		respostaFormularioRepository.saveAll(Arrays.asList(rf1,rf2));		

		Noticia n1 = new Noticia(null, "Quem irá vencer as eleições em 2022?", "Lula ou Bolsonaro?", "Eleição super disputada neste ano. Leia mais sobre", "/dados/capa/noticias", "/eleicao-2022", u4);
		Noticia n2 = new Noticia(null, "Tudo sobre kubernetes", "A inovação em escalonamento", "Venha saber mais sobre Kubernetes", "/dados/capa/noticias", "/tudo-sobre-kubernetes", u4);
		noticiaRepository.saveAll(Arrays.asList(n1,n2));

		PostagemNoticia p1 = new PostagemNoticia(null, new Date(2022, 5, 20, 1, 42), new Date(2022, 5, 20, 1, 42), true, u4, n1);
		PostagemNoticia p2 = new PostagemNoticia(null, new Date(2022, 5, 20, 1, 42), new Date(2022, 5, 20, 1, 42), true, u4, n2);
		PostagemNoticiaRepository.saveAll(Arrays.asList(p1,p2));
		
		Tema t1 = new Tema(null, "teste", 30, false, "/dados/tema/img0");
		Tema t2 = new Tema(null, "teste2", 50, false, "/dados/tema/img1");
		TemaRepository.saveAll(Arrays.asList(t1,t2));

		// CompraTema ct1 = new CompraTema(null, new Date(2022, 5, 20, 1, 42), 30, u5, t1);
		// CompraTema ct2 = new CompraTema(null, new Date(2022, 5, 20, 1, 44), 50, u6, t2);
		// CompraTemaRepository.saveAll(Arrays.asList(ct1,ct2));
		
		Enquete e1 = new Enquete(null, "Melhor time do Rio", true, true, u3);
		Enquete e2 = new Enquete(null, "Qual a sua área em TI?", true, true, u4);
		EnqueteRepository.saveAll(Arrays.asList(e1,e2));
		
		OpcaoVoto ov1 = new OpcaoVoto(null, "Flamengo", e1);
		OpcaoVoto ov2 = new OpcaoVoto(null, "Vasco", e1);
		OpcaoVoto ov3 = new OpcaoVoto(null, "Fluminense", e1);
		OpcaoVoto ov4 = new OpcaoVoto(null, "Botafogo", e1);
		OpcaoVotoRepository.saveAll(Arrays.asList(ov1,ov2,ov3,ov4));
		
		Voto v1 = new Voto(null, new Date(2022, 5, 20, 1, 42), ov1, u2);
		Voto v2 = new Voto(null, new Date(2022, 5, 20, 1, 44), ov2, u3);
		VotoRepository.saveAll(Arrays.asList(v1,v2));
		
		Anuncio an1 = new Anuncio(null, "Perfume", "https://www.google.com.br", "/dados/anuncio/img1", "/dados/anuncio/img2", "/dados/anuncio/img3", u2);
		Anuncio an2 = new Anuncio(null, "Bolsa", "https://www.amazon.com.br", "/dados/anuncio/img4", "/dados/anuncio/img5", "/dados/anuncio/img6", u2);
		AnuncioRepository.saveAll(Arrays.asList(an1,an2));

		AreaAnuncio a1 = new AreaAnuncio(null, "Topo");
		AreaAnuncio a2 = new AreaAnuncio(null, "Lateral");
		AreaAnuncioRepository.saveAll(Arrays.asList(a1,a2));

		// PostagemAnuncio pt1 = new PostagemAnuncio(null, new Date(2022, 5, 20), new Date(2022, 5, 25),an1 ,a1);
		// PostagemAnuncio pt2 = new PostagemAnuncio(null, new Date(2022, 5, 20), new Date(2022, 5, 25),an2 ,a2);
		// PostagemAnuncioRepository.saveAll(Arrays.asList(pt1,pt2));
		
	}

}