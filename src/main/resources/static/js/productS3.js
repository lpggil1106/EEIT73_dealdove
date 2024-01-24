import {} from "https://cdn.jsdelivr.net/npm/aws-sdk@2.1128.0/dist/aws-sdk.min.js";
const s3 = new AWS.S3({
    accessKeyId: 'AKIARQLKGSKVNEBVBLXF',
    secretAccessKey: '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'
});

export {s3};