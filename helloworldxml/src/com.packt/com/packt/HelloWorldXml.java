package com.packt;

public class HelloWorldXml{
	public static void main(String[] args) throws JAXBException{
		
		JAXBContext jaxb = JAXBContext.newInstance(Message.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT,Boolean.TRUE);
		StringWriter writer = new StringWriter();
		marshaller.marshal(new Message(), writer);
		System.out.println(writer.toString());
	}
}


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Messages{
	@XmlElement
	public final String message = "Hello World in XML";
}
