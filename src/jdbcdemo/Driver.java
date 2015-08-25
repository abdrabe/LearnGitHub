package jdbcdemo;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Stackoverflow";
		String username = "root";
		String password = "rabe";
		try{
			// connetcion to database
			Connection myConn = DriverManager.getConnection(url,username,password);
			// statement
			Statement myStmt = myConn.createStatement();
			int id = 22;
			String name = "rabe";
			String texts = "&lt;p&gt;Everything went &lt;em&gt;remarkably&lt;/em&gt; well. This is what we've got done:&lt;/p&gt;&#xA;&#xA;&lt;ul&gt;&#xA;&lt;li&gt;Meta SO is now a per-site child meta, just like every other meta site (but MSE)&lt;/li&gt;&#xA;&lt;li&gt;MSE has been launched in production, and is functioning well&lt;/li&gt;&#xA;&lt;li&gt;chat.meta.stackoverflow.com has been relocated to chat.meta.stackexchange.com&lt;/li&gt;&#xA;&lt;li&gt;A &lt;em&gt;lot&lt;/em&gt; of cache / tag engine related things have been fixed following the split&lt;/li&gt;&#xA;&lt;/ul&gt;&#xA;&#xA;&lt;p&gt;Effectively, it's done, but there's a ton of minor details that still need attention, which we're going to be busy cleaning up for the next day or two. There's design tweaks, tweaks to settings, minor text glitches and other stuff we're working on cleaning up.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;I will begin migrating some of the relevant content from MSE back to MSO at some point in the morning on tomorrow (4/17) NY time. We're not yet in a position to fire up the bulk migration tools, but will be very soon. I'll also have a blog post up by tomorrow afternoon, which will basically summarize what we've posted leading up to the split.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;I'll be updating this post as things progress - for now, we're split and stable.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;&lt;strong&gt;Update&lt;/strong&gt;&lt;/p&gt;&#xA;&#xA;&lt;p&gt;There are still a bunch of database migrations going on surrounding other projects (mostly tag system improvements), I'm holding off until that's done to start migrating selected posts in bulk. &lt;/p&gt;&#xA;&#xA;&lt;p&gt;However, we're starting to 'cherry pick' a few, sending them over manually, which will continue on and off today. I expect to start the &lt;em&gt;bulk&lt;/em&gt; of sending things back over on Friday,  April 18, as things should be settled and stable by then. For details see &lt;a href=&quot;http://meta.stackoverflow.com/questions/250976/migrations-are-now-in-progress&quot;&gt;Migrations are now in progress&lt;/a&gt;.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;Just keep doing what you're doing here, which is awesome, and I'm very happy to see you doing it. The old stuff isn't going anywhere, and there's plenty of things to talk about.&lt;/p&gt;&#xA;&#xA;&lt;p&gt;SE Blog: &lt;a href=&quot;http://blog.stackoverflow.com/2014/04/announcing-the-launch-of-meta-stack-exchange/&quot;&gt;Announcing The Launch Of Meta Stack Exchange&lt;/a&gt;&lt;/p&gt;&#xA;";
					// the mysql insert statement
		      String query = " insert into Test (id, name, texts)"
		        + " values (?, ?, ?)";
		 
		       //create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = myConn.prepareStatement(query);
		      preparedStmt.setInt (1, id);
		      preparedStmt.setString (2, name);
		      preparedStmt.setString   (3, texts);
		
		 
		      // execute the preparedstatement
		     // preparedStmt.execute();
			
			//query
			
			ResultSet myRS = myStmt.executeQuery("select * from test where id =22");
			//System.out.println("INSERT INTO Test(id,name,texts) VALUES (" + id + "," + name + "," + texts + ")");
			//myStmt.executeUpdate("select * from test where id =21");
			// result set
			while(myRS.next())
			{
				//System.out.println(myRS.toString());
				System.out.println(myRS.getString("texts"));
			}
		}catch (Exception exc)
		{
			exc.printStackTrace();
		}

	}

}
