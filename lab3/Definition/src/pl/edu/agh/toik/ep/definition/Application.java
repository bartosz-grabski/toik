package pl.edu.agh.toik.ep.definition;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import pl.edu.agh.toik.ep.definition.translator.ITranslator;

public class Application implements IApplication {

	private static final String[] words = { "raz", "dwa", "trzy", "cztery",
		"pięć", "sześć", "siedem", "osiem", "dziewięć", "dziesięć" };
	
	@Override
	public Object start(IApplicationContext context) throws Exception {

		System.out.println("Hello RCP World");
		//this.listRegisteredTranslatorsWithAttributes();
		this.getTranslatorAndTranslate();
		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	private void listRegisteredTranslatorsWithAttributes() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.ep.translator");

		for (IConfigurationElement e : config) {

			try {
				final ITranslator t = (ITranslator) e
						.createExecutableExtension("class");
			} catch (CoreException ex) {
				throw new RuntimeException(ex);
			}
			System.out.println(String.format("Translator %s from %s to %s",
					e.getAttribute("name"), e.getAttribute("lang_in"),
					e.getAttribute("lang_out")));
		}

		if (config.length == 0) {
			System.out.println("No registered translators");
		}
	}
	
	private void getTranslatorAndTranslate() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("pl.edu.agh.toik.ep.translator");
		
		for (IConfigurationElement e : config) {

			try {
				final ITranslator t = (ITranslator) e
						.createExecutableExtension("class");
				System.out.println(String.format("Translator %s",
						e.getAttribute("name")));
				
				for (String word : this.words) {
					System.out.println(String.format("%s -> %s",word,t.translate(word)));
				}
			} catch (CoreException ex) {
				throw new RuntimeException(ex);
			}
			
		}

	}

}
