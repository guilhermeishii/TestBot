package ishiilindo.TestBot.Events;

import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter{
	
	String[] messages = {
			"Never gonna give [member] up. Never let [member] down!",
			"A wild [member] appeared.",
			"Brace yourselves. [member] just joined to the serve.",
			"It's dangerous to go alone, take [member]!",
			"Ha! [member] has joined! You activated my trap card!"
	};
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Random rand = new Random();
		int num = rand.nextInt(messages.length);
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(new Color(0x66d8ff));
		join.setDescription(messages[num].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
	}
	
}