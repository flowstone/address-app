package xueyao.address.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Simon.Xue
 * @date 2019-12-18 14:12
 **/
@XmlRootElement(name = "persons")
public class PersonListWrapper {

    private List<Person> personList;

    @XmlElement(name = "person")
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
