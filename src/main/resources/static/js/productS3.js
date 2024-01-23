import {} from "https://cdn.jsdelivr.net/npm/aws-sdk@2.1128.0/dist/aws-sdk.min.js";
const s3 = new AWS.S3({
    accessKeyId: 'AKIARQLKGSKVNEBVBLXF',
    secretAccessKey: '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'
});

export {s3};