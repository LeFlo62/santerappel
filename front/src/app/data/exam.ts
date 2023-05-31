export interface ExamListItem{

    id : string;
    name : string;
    age : number[];
    bigDescription: string;
    countryList: string[];
    description: string;
    isVaccine: boolean;
    recommendation?: string[];
    familyBackground?: string;
    personalBackground?: string;
    sex: string[];

    isExpanded: boolean;
}