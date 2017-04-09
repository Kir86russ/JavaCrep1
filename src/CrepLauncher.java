

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

    public class CrepLauncher {

        @Option(name = "-v", metaVar = "InvertF", required = false, usage = "Invert filtration")
        private boolean invert;

        @Option(name = "-i", metaVar = "IgnoreCase", required = false, usage = "Ignore Case")
        private boolean ignoreCase;

        @Option(name = "-r", metaVar = "ByRegex", required = false, usage = "Find by regex")
        private boolean findByRegex;

        @Argument(required = true, metaVar = "InputName", index = 1, usage = "Input file name")
        private File inputFileName;

        @Argument(required = true, metaVar = "Keyword", usage = "Keyword")
        private String word;

        public static void main(String[] args) {
            new CrepLauncher().launch(args);
        }

        private void launch(String[] args) {
            CmdLineParser parser = new CmdLineParser(this);

            try {
                parser.parseArgument(args);
            } catch (CmdLineException e) {
                System.err.println(e.getMessage());
                System.err.println("java -jar crep.jar -v -i -r expected ");
                parser.printUsage(System.err);
                return;
            }

            Crep crep = new Crep(findByRegex, invert, ignoreCase);
            try {
                crep.show(crep.read(inputFileName, word));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

    }

