import java.io.IOException;
import java.util.Iterator;
import  org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import  org.apache.hadoop.io.Text;
import  org.apache.hadoop.mapred.MapReduceBase;
import  org.apache.hadoop.mapred.OutputCollector;
import  org.apache.hadoop.mapred.Reducer;
import  org.apache.hadoop.mapred.Reporter;


public class SimpleReducer extends MapReduceBase implements Reducer<Text, Text, NullWritable, Text>  {
	
	
  public void reduce(Text key, Iterator<Text> values, OutputCollector<NullWritable, Text> output, Reporter reporter) throws IOException
  {

	  while(values.hasNext())
		{
			output.collect(NullWritable.get(), values.next());
		}
  }
}
