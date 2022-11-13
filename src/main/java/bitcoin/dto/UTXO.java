package bitcoin.dto;

/**
 * @author ziyou.cxf
 * @version : UTXO.java, v 0.1 2022年07月12日 10:12 ziyou.cxf Exp $
 */
public class UTXO {

    private byte[] prevTxHash;

    private int outputIndex;

    public UTXO(byte[] prevTxHash, int outputIndex) {
        this.prevTxHash = prevTxHash;
        this.outputIndex = outputIndex;
    }
}
