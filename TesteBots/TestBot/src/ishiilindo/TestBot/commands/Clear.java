package ishiilindo.TestBot.commands;

import java.awt.Color;
import java.util.List;

import ishiilindo.TestBot.Principal;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Principal.prefix + "clear")) {
			if (args.length < 2){
				//Utilização
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(new Color(0xff2222));
				usage.setTitle("⚠ Especifique a quantidade que será deletada.");
				usage.setDescription("Utiliza: '" + Principal.prefix + "clear[# quantidade de mensagens]");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel()
							.getHistory()
							.retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					//Sucesso
					EmbedBuilder sucess = new EmbedBuilder();
					sucess.setColor(new Color(0x22ff22));
					sucess.setTitle("✅ Deletado com sucesso " + args[1] + " mensagens.");
					event.getChannel().sendMessage(sucess.build()).queue();;
					
				} catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						//Muitas mensagens selecionadas
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(new Color(0xff2222));
						error.setTitle("🛑 Muitas menssagem selecionadas!");
						error.setDescription("Somente de 1-100 mensagens podem ser deletadas por vez.");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						//Mensagens muito velhas
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(new Color(0xff2222));
						error.setTitle("🛑 Menssagem selecionadas são mais velhas que duas semanas!");
						error.setDescription("Mensagens que passaram de 2 semanas não podem ser deletadas.");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
				
			}
		}
		
	}
	
}
