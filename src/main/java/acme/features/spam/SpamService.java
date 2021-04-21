package acme.features.spam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spam.Spam;

@Service
public class SpamService {

	@Autowired
	private SpamRepository spamRep;

	public boolean filtroSpam(final String text, final Integer umbralMaximo) { 
		
		final List<Spam> todoSpam= this.spamRep.findAllSpam();
		final List<String>spamWords= new ArrayList<String>();
		for(int j=0; j<todoSpam.size();j++) {
			spamWords.add(todoSpam.get(j).getSpamWords());
		}	
		
		final String textoConFormato ="."+text.toLowerCase().replace(":", ".").replace(" ", ".").replace(";", ".")
			.replace(",", ".").replace("(", ".").replace(")", ".").replace("-", ".").replace("_", ".")
			.replace(">", ".").replace("<", ".").replace("¡", ".").replace("?", ".").replace("¿", ".")
			.replace("!", ".").replace("}", ".").replace("{", ".").replace("*", ".").replace("+", ".")+".";
		
		final String[] textoCortado= textoConFormato.split(".");
		Integer procentajeSpamDetectado = 0;
		final Integer tamanoTexto=textoCortado.length+1;

		for(int i=0; i<spamWords.size(); i++) {
			final String palabra = spamWords.get(i);
			if(text.contains(palabra)){
				procentajeSpamDetectado=procentajeSpamDetectado+(100/tamanoTexto-1);
			}
		}
		if(umbralMaximo<procentajeSpamDetectado) {
			return true;
		}else {
			return false ;	
		}
		
	}

}
