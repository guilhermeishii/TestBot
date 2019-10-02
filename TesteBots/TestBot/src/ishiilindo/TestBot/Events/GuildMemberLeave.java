package ishiilindo.TestBot.Events;

import java.awt.Color;
import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMemberLeave extends ListenerAdapter{
	
	String[] messages = {
			"[member] left, the party's over!"
	};
	
	public void onGuildMemberLeave(GuildMemberLeaveEvent event) {
		Random rand = new Random();
		int num = rand.nextInt(messages.length);
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(new Color(0x66d8ff));
		join.setDescription(messages[num].replace("[member]", event.getMember().getAsMention()));
		
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
	}

}
