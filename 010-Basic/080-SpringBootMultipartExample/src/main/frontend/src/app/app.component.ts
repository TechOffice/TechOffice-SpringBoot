import { Component, ElementRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less']
})
export class AppComponent {

  @ViewChild('file1')
  private fileElementRef1: ElementRef;

  @ViewChild('file2')
  private fileElementRef2: ElementRef;

  constructor(private http: HttpClient) { }


  submit(): void {
    const fileData = new FormData();
    const file1 = this.retrieveFile(this.fileElementRef1);
    if (file1){
      fileData.append('files', file1);
    }
    const file2 = this.retrieveFile(this.fileElementRef2);
    if (file2){
      fileData.append('files', file2);
    }
    const jsonObject = {
      name: 'testing'
    };
    fileData.append('content', 
      new Blob([JSON.stringify(jsonObject)], {type: "application/json"})
    );

    console.log(fileData);
    this.http.post('/api/testMultipart', fileData).subscribe();
  }

  private retrieveFile(fileElementRef: ElementRef): any {
    if (fileElementRef
      && fileElementRef.nativeElement
      && fileElementRef.nativeElement.files
      && fileElementRef.nativeElement.files.length > 0) {
        return fileElementRef.nativeElement.files[0];
    }
  }

}

