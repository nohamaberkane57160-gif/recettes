package fr.lycee.recettes;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class RecettesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecettesApplication.class, args);
	}
@ManyToMany
@JoinTable (name = "article_tag",
		joinColumns = @JoinColumn(name = "article_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id"))
private List<Tag> tags = new ArrayList<>();

	@PostMapping
	public String enregistrer(@Valid @ModelAttribute Article article,
							  BindingResult resultat, Model model) {
		if (resultat.hasErrors()) {
			// re-fournir les donnees utiles au formulaire puis le reafficher
			return "articles/formulaire";
		}
		// ... enregistrement ...
		return "redirect:/articles";
	}
}
