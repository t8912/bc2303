package week4.sorting;

import java.time.LocalDate;
import java.util.Comparator;

//public class Customer {

  
//}


public class Customer implements Comparator<Customer>{
  private int id;
  private String name;
  private LocalDate joinDate;
  // ...
  // constructors + getters + toString()


  public Customer(int id, String name, LocalDate joinDate) {
    this.id = id;
    this.name = name;
    this.joinDate = joinDate;

  }

  public int getId() {
    return id;
}

public String getName() {
    return name;
}

public LocalDate getJoinDate() {
    return joinDate;
}



@Override
public int compareTo(Customer o) {
  //return this.id > o.id ? -1 : 0; // if this.id > o.id, this object less than special
  if (this.id == o.id) {
    if (this.name.charAt(0) > o.name.charAt(0)) {
      return -1;
    }
    return 1;
  }
  return this.id > o.id ? -1 : 0;
}
 

/*@Override
    public int compareTo(Customer o) {
        int idCompare = Integer.compare(this.id, o.id);
        if (idCompare == 0) {
            int nameCompare = Character.compare(this.name.charAt(0), o.name.charAt(0));
            if (nameCompare == 0) {
                return this.joinDate.compareTo(o.joinDate);
            }
            return nameCompare;
        }
        return idCompare;
      }

 * 
 */

      //@Override
      //public int compare(Customer o1, Customer o2) {
      //return o1.getName().compareTo(o2.getName());
      //}
      
      //@Override
      //public int compare(Customer o1, Customer o2){
       //return o1.getJoinDate().compareTo(o2.getJoinDate());
      //}

/*
 *  if (idCompare == 0) {
      int nameCompare = this.name.compareTo(o.name);
      if (nameCompare == 0) {
        return this.joinDate.compareTo(o.joinDate);
      }
      return nameCompare;
      }
      return idCompare;
    }
 */
   
  


@Override
public String toString() {
return new StringBuilder() //
.append("[") //
.append(id) //
.append(",") //
.append(name) //
.append(",") //
.append(joinDate)//
.append("]") //
.toString();

/*
 * @Override
//public int compareTo(Customer o) {
    int idCompare = Integer.compare(this.id, o.id);
    if (idCompare == 0) {
        int nameCompare = Character.compare(this.name.charAt(0), o.name.charAt(0));
        if (nameCompare == 0) {
            return this.joinDate.compareTo(o.joinDate);
        }
        return nameCompare;
    }
    return idCompare;
}
 */

}

}
