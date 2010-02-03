import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;	

public class MainRunner extends Configured implements Tool{

	public int run(String[] args) throws IOException
	{
		
		JobConf conf = new JobConf(MainRunner.class);  
			
		conf.setJobName("Tacos");
		conf.setMapperClass(SimpleMapper.class); //set mapper.  Changes.
		conf.setMapOutputKeyClass(Text.class);
		conf.setReducerClass(SimpleReducer.class);  //Set reducer.  Changes.
		conf.setOutputKeyClass(NullWritable.class);
		conf.setOutputValueClass(Text.class);    //Set output class. Changs.
		
		conf.setNumReduceTasks( 1 );	//uncomment to use.
		//conf.setNumMapTasks( 1 );		//uncomment to use.

	    FileInputFormat.setInputPaths(conf, new Path(args[0]));  
	    FileOutputFormat.setOutputPath(conf, new Path(args[1]));  
		
		JobClient.runJob(conf);
		return 0;
		
	}
	
	public static void main(String[] args) throws Exception{

		int exitCode = ToolRunner.run(new MainRunner(), args);
		System.exit(exitCode);
	}
}
