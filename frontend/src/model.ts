export interface Task{
    id?: string;
    task: string;
    description: string;
    status?: string;
}

export interface PageData{
    results: Array<Task>;
}