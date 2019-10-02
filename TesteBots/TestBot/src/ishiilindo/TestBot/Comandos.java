package ishiilindo.TestBot;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Comandos extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		
		if (args[0].equalsIgnoreCase(Principal.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("(☞ﾟヮﾟ)☞ Informações");
			info.setDescription("Informações completamente irrelevantes para o Teste do TestBot");
			info.setFooter("Create by Ishiilindão", event.getMember().getUser().getAvatarUrl());
			info.setColor(new Color(0xf56416));
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();			
			info.clear();
		}
		
		if (args[0].equalsIgnoreCase(Principal.prefix + "hello")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Olá Mundo! Eu estou vivo!").queue();
		}
	}

}
