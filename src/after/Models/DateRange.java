package after.Models;

import java.util.Date;

public class DateRange {
  private Date start;
  private Date end;

  public Date getStart() {
    return start;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public void setStart(Date start) {
    this.start = start;
  }
}
