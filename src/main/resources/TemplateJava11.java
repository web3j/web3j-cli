package <package_name>;

import <package_name>.generated.contracts.HelloWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.evm.Configuration;
import org.web3j.evm.EmbeddedWeb3jService;
import org.web3j.evm.PassthroughTracer;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class <project_name> {

private static final Logger log = LoggerFactory.getLogger(<project_name>.class);


public static void main(String[]args) throws Exception {
        Credentials credentials=loadCredentials("<wallet_name>","<wallet_password_placeholder>");
        Configuration configuration=fundAccount(credentials);
        Web3j web3j=createWeb3jService(configuration);
        HelloWorld helloWorld = deployHelloWorld(web3j,credentials,new DefaultGasProvider());
        callGreetMethod(helloWorld);
        }

private static Credentials loadCredentials(String walletName,String walletPassword)throws CipherException,IOException,URISyntaxException{
        String root=System.getProperty("user.dir");
        String pathToWallet=String.join(File.separator,root,"src","test","resources","wallet",walletName);
        File file=new File(pathToWallet);

        log.info("Loading wallet file: "+walletName+" from resources.");
        log.info("Creating credentials from from wallet.");
        return WalletUtils.loadCredentials(walletPassword,file);
        }

private static Configuration fundAccount(Credentials credentials){
        // Use the Web3j CLI fund command to obtain testnet Ether
        // See <Link to docs here>
        log.info("Funding address "+credentials.getAddress()+" with "+10+" ether.");
        return new Configuration(new Address(credentials.getAddress()),10);

        }

private static Web3j createWeb3jService(Configuration configuration){
        // To run against a real Ethereum node use HttpService instead of EmbeddedWeb3jService and pass in the URL of your node.
        log.info("Creating a web3j service locally with EmbeddedWeb3jService.");
        return Web3j.build(new EmbeddedWeb3jService(configuration,new PassthroughTracer()));
        }

private static HelloWorld deployHelloWorld(Web3j web3j,Credentials credentials,ContractGasProvider contractGasProvider)throws Exception{
        return HelloWorld.deploy(web3j,credentials,contractGasProvider,"Hello Blockchain World!").send();
        }

private static void callGreetMethod(HelloWorld helloWorld)throws Exception{
        log.info("Calling the greeting method of contract HelloWorld");
        String response = helloWorld.greeting().send();
        log.info("Contract returned: "+response);
        }
        }