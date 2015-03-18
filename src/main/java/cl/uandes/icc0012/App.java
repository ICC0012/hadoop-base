package cl.uandes.icc0012;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class App extends Configured implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance();
        
        // Useless unless Mapper and Reducer classes live in another JAR. Then you should set the JAR to that containing
        // such classes.
        job.setJarByClass(App.class);
        job.setJobName("App Name");
        
        // More configs to be done here...
        // ...
        // ...
        
        boolean success = job.waitForCompletion(true);
        if (success) {
            System.out.println("Success!");
            return 0;
        } else {
            System.out.println("Failure!");
            return 1;
        }
    }

    public static void main(String[] args) {
        int returnValue = -1;
        try {
            App app = new App();
            returnValue = ToolRunner.run(app, args);
        } catch (Exception e) {
            System.err.println("Error!");
            e.printStackTrace();
        }
        System.exit(returnValue);
    }
}
