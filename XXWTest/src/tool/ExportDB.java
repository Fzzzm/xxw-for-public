package tool;

import java.util.EnumSet;

import oracle.net.aso.l;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class ExportDB {
	public static void main(String[]args){  
/*        //Ĭ�϶�ȡhibernate.cfg.xml�ļ�  
        Configuration cfg = new Configuration().configure();  
        ////���ɲ����sql���ļ�����ǰĿ¼�������ݿ�  
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);  */
		Configuration configuration=new Configuration().configure();
		SchemaExport export=new SchemaExport(configuration);
		export.create(true, true);
    }  
}
