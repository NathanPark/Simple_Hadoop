import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;	



public class SimpleMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text>{

		public void map (LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException
		{
			
			Text first = new Text(value.toString() + " tacos are good");
	        
			output.collect(value, first);
		}
}
