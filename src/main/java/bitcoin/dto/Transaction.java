package bitcoin.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author ziyou.cxf
 * @version : Transaction.java, v 0.1 2022年07月12日 9:47 ziyou.cxf Exp $
 */
public class Transaction {

    // 交易ID，本次交易所有数据的Hash
    private byte[] hash;

    // 消费者信息，Input是在Transaction中定义的
    private ArrayList<Input> inputs;

    // 接收者信息
    private ArrayList<Output> outputs;

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public Integer numInputs() {
        return inputs.size();
    }

    public Integer numOutputs() {
        return outputs.size();
    }

    public Input getInput(int index) {
        return inputs.get(index);
    }

    public ArrayList<Input> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<Input> inputs) {
        this.inputs = inputs;
    }

    public Output getOutput(int index) {
        return outputs.get(index);
    }

    public ArrayList<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(ArrayList<Output> outputs) {
        this.outputs = outputs;
    }

    public byte[] getRawDataToSign(int index) {
        return null;
    }

    public static class Output {
        /**
         * 验证地址
         */
        public PublicKey address;

        /**
         * value in bitcoins of the output
         */
        public BigDecimal value;
    }

    public static  class Input {
        public byte[] signature;

        public byte[] prevTxHash;

        public int outputIndex;
    }
}
