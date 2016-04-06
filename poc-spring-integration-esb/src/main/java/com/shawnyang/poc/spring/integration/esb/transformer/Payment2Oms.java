package com.shawnyang.poc.spring.integration.esb.transformer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.Transformer;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import com.shawnyang.poc.spring.integration.oms.i.PaymentData;
import com.shawnyang.poc.spring.integration.oms.i.PaymentDataBatch;

public class Payment2Oms {

	@Value("${oms.payment.file.done}")
	private String destDir;

	@Transformer
	public PaymentDataBatch transform(File file) throws IOException {

		PaymentDataBatch out = new PaymentDataBatch();

		ICsvMapReader mapReader = null;
		try {
			mapReader = new CsvMapReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);

			// the header columns are used as the keys to the Map
			final String[] header = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
			final CellProcessor[] processors = getProcessors();

			Map<String, Object> customerMap;
			while ((customerMap = mapReader.read(header, processors)) != null) {
				PaymentData outItem = new PaymentData();
				outItem.setCreditCardNumber((String) customerMap.get("2"));
				outItem.setDate((Date) customerMap.get("3"));
				outItem.setAmount((BigDecimal) customerMap.get("7"));
				out.getPaymentData().add(outItem);
			}

		} finally {
			if (mapReader != null) {
				mapReader.close();
			}
		}
		FileUtils.moveFileToDirectory(file, new File(destDir), true);
		return out;
	}

	private CellProcessor[] getProcessors() {
		final CellProcessor[] processors = new CellProcessor[] { //
				new Trim(), // 030030199
				new Trim(), // 524106xxxxxx6929
				new ParseDate("yyyy/MM/dd"), // 2016/03/16
				new ParseBigDecimal(), // 6000
				new Trim(), // 848038
				new Trim(), // 50101800
				new ParseBigDecimal(), // 5880
				new ParseDate("yyyy/MM/dd"), // 2016/03/17
				new Trim()// 3251532A04
		};

		return processors;
	}
}
