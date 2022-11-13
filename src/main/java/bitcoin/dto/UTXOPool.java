package bitcoin.dto;

import java.util.Map;

/**
 * @author ziyou.cxf
 * @version : UTXOPool.java, v 0.1 2022年07月12日 9:46 ziyou.cxf Exp $
 * @desc: 记录当前还没有被所有者消费的硬币以及他的来源
 */
public class UTXOPool {

    /**
     * UTXO就是Input的hash和index做的可hash和比较的数据
     */
    private Map<UTXO, Transaction.Output> H;

    public boolean contains(UTXO utxo) {
        return H.containsKey(utxo);
    }

    public Transaction.Output getTxOutput(UTXO utxo) {
        return H.get(utxo);
    }

    public void addUTXO(UTXO utxo, Transaction.Output o) {
        H.put(utxo, o);
    }

    public void removeUTXO(UTXO utxo) {
        H.remove(utxo);
    }
}
