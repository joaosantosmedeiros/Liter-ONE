package com.jota.literalura;

import com.jota.literalura.db.model.AutorModel;
import com.jota.literalura.db.model.LivroModel;
import com.jota.literalura.db.repository.AutorRepository;
import com.jota.literalura.db.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class LiterAluraChallengeApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		ClienteHttp clienteHttp = new ClienteHttp();
		int opc;
		do{
			System.out.println("""
________________________________________________
Escolha o número de sua opção:
1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em um determinado ano
5 - Listar livros em um determinado idioma
0 - Sair
""");
			opc = scanner.nextInt();
			scanner.nextLine();

			switch (opc) {
				case 1:
					System.out.print("Digite o nome do livro: ");
					String titulo = scanner.nextLine();

					Livro livro = clienteHttp.buscarLivro(titulo);
					if(livro != null){
						Author[] autores = livro.getAuthors();
						if(livroRepository.findByTitulo(livro.getTitle()).isEmpty()){
							LivroModel livroModel = new LivroModel(
									livro.getTitle(),
									String.join(", ", livro.getLanguages()),
									Arrays.stream(autores).map(Author::getName).collect(Collectors.joining()),
									livro.getDownload_count()
							);
							livroRepository.save(livroModel);

							for (Author autor : autores) {
								var autorExiste = autorRepository.findByNome(autor.getName());
								if (autorExiste.isEmpty()) {
									AutorModel autorModel = new AutorModel(autor.getName(), autor.getBirth_year(), autor.getDeath_year());
									autorModel.getLivros().add(livroModel);
									autorRepository.save(autorModel);
								}else{
									autorExiste.get().getLivros().add(livroModel);
									autorRepository.save(autorExiste.get());
								}
							}
						}

						livro.exibirLivro();
					}else{
						System.out.println("Livro não encontrado.");
					}
					break;
				case 2:
					var livros = livroRepository.findAll();
					livros.forEach(LivroModel::exibirLivro);
					break;
				case 3:
					var autoresBuscados = autorRepository.findAll();
					autoresBuscados.forEach(AutorModel::exibirAutor);
					break;
				case 4:
					System.out.print("Digite o ano: ");
					int ano = scanner.nextInt();

					var autores = autorRepository.findAll();
					for(AutorModel autor : autores){
						if(autor.getAnoNascimento() <= ano && autor.getAnoFalecimento() >= ano){
							autor.exibirAutor();
						}
					}
					break;
				case 5:
					System.out.print("Digite o idioma a ser buscado: ");
					String idioma = scanner.next();
					var livrosBuscados = livroRepository.findByIdioma(idioma);
					for(LivroModel livroBuscado : livrosBuscados){
						livroBuscado.exibirLivro();
					}
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida, digite novamente.");
					break;
			}
		}while(opc != 0);
	}
}
