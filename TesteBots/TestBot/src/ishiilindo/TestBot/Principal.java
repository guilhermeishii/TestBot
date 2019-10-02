package ishiilindo.TestBot;

import javax.security.auth.login.LoginException;

import ishiilindo.TestBot.Events.GuildMemberJoin;
import ishiilindo.TestBot.Events.GuildMemberLeave;
import ishiilindo.TestBot.commands.Clear;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;


public class Principal {
	
		public static String prefix = "~";
		public static JDA jda;
		
	//main Method
	public static void main(String[] args) throws LoginException {
		String token = "NjI4OTI4ODM1ODAyMzY1OTgy.XZSVtg.qwvunG-SwaWTX3sxK6yIIWIg-dU";
		
		jda = new JDABuilder(AccountType.BOT).setToken(token).build();
		
		jda.getPresence().setStatus(OnlineStatus.IDLE);
		jda.getPresence().setGame(Game.playing("Ragnarok Online"));
		
		jda.addEventListener(new Comandos());
		jda.addEventListener(new Clear());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMemberLeave());
		
	}

}
